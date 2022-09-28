package com.usermgmt.MvcController;

import com.usermgmt.Dto.Mst_BranchInsertDTO;
import com.usermgmt.Dto.UpdateBranchDTO;
import com.usermgmt.Entity.Mst_Branch;
import com.usermgmt.Service.Mst_BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/branchMvc")
public class ControllerMvc {

    @Autowired
    private Mst_BranchService mst_branchService;

    private final Integer maxRows = 10;

    @GetMapping("/index")
    public String listBranch(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "") String name,
                             Model model){

        Pageable pageable = PageRequest.of(page - 1, maxRows, Sort.by("id"));

        Page<Mst_Branch> branchGrid = mst_branchService.getAllBranch(pageable, name);

        model.addAttribute("branchGrid", branchGrid.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", branchGrid.getTotalPages());
        model.addAttribute("breadCrumbs", "All Branch");

        return "branch/branch-index";
    }

    @GetMapping("/upsertForm")
    public String BranchUpsertForm(@RequestParam(required = false) String id,
                                 Model model){

        if(id != null){
            UpdateBranchDTO branchDTO = mst_branchService.getBranchToUpdate(id);

            model.addAttribute("branch", branchDTO);
            model.addAttribute("type","update");
            model.addAttribute("breadCrumbs","Branch Index / Update Branch");
        } else {
            Mst_BranchInsertDTO branchDTO = new Mst_BranchInsertDTO();

            model.addAttribute("branch", branchDTO);
            model.addAttribute("type","insert");
            model.addAttribute("breadCrumbs","Branch Index / Insert Branch");
        }

        return "branch/upsert-form";
    }

    @PostMapping("/insert")
    public String insertRoom(@Valid @ModelAttribute("branch") Mst_BranchInsertDTO insertDTO,
                             BindingResult bindingResult,
                             Model model){

        if (bindingResult.hasErrors()){

            model.addAttribute("type","insert");
            model.addAttribute("breadCrumbs","Branch / Insert Branch");

            return "branch/upsert-form";
        }else{
            mst_branchService.insertBranch(insertDTO);

            return "redirect:/branchMvc/index";
        }
    }

    @PostMapping("/update")
    public String updateBranch(@Valid @ModelAttribute("branch") UpdateBranchDTO updateBranchDTO,
                             BindingResult bindingResult,
                             Model model){

        if (bindingResult.hasErrors()){

            model.addAttribute("type","update");
            model.addAttribute("breadCrumbs","Branch / Update Branch");

            return "branch/upsert-form";
        } else{
            mst_branchService.updateBranchById(updateBranchDTO, updateBranchDTO.getId());

            return "redirect:/branchMvc/index";
        }
    }

    @GetMapping("/delete")
    public String deleteBranchById(@RequestParam(required = true) String id,
                                   Model model){

        Mst_Branch branchById = mst_branchService.getBranchById(id);

        if (branchById != null){

            mst_branchService.deleteById(id);

            return "redirect:/branchMvc/index";
        }else {

            model.addAttribute("id", id);
            model.addAttribute("breadCrumbs","Id Not Found");
            model.addAttribute("type", "delete");

            return "branch/not-found";
        }

    }
}
