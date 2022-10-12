package com.usermgmt.restController;

import com.usermgmt.dto.InsertBranchDTO;
import com.usermgmt.dto.UpdateBranchDTO;
import com.usermgmt.entity.MstBranch;
import com.usermgmt.NotFoundException;
import com.usermgmt.service.MstBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/branch")
public class MstBranchController {

    @Autowired
    private MstBranchService mst_branchService;

    private final Integer maxRows = 10;

    @PostMapping("/add")
    public ResponseEntity<Object> addBranch(@Valid @RequestBody InsertBranchDTO dto){
        try {
            System.out.println("insert branch addd");
            MstBranch mst_branch = mst_branchService.insertBranch(dto);
            return new ResponseEntity<>(mst_branch, HttpStatus.CREATED);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

    @GetMapping("/list")
    public ResponseEntity<Object> listBranch(@RequestParam(defaultValue = "1") Integer page,
                                                       @RequestParam(defaultValue = "") String name){

        try {
            Pageable pageable = PageRequest.of(page - 1, maxRows, Sort.by("id"));

            Page<MstBranch> grid = mst_branchService.getAllBranch(pageable, name);

            return new ResponseEntity<>(grid, HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateBranch(@RequestBody UpdateBranchDTO updateDto,
                                                   @RequestParam(required = true)String id){

        //findbyid
        try {

            if (mst_branchService.getBranchById(id) == null){
                throw new NotFoundException("Branch with Id " + id + " Not Found!");

            }else{

                MstBranch branchUpdate = mst_branchService.updateBranchById( updateDto, id);

                return new ResponseEntity<>(branchUpdate, HttpStatus.ACCEPTED);
            }
        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());


        }

    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteBranch(@RequestParam(required = true) String id){
        try {
            MstBranch mst_branch = mst_branchService.getBranchById(id);
            if(mst_branch == null){
                throw new NotFoundException("Branch with Id " + id + " Not Found!");
            } else{
                mst_branchService.deleteById(id);
                return new ResponseEntity<>("Succes Delete Mst_Branch With Id " + id, HttpStatus.OK);
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }



    @GetMapping("/{branchId}")
    public ResponseEntity<Object> searchBranchId(@PathVariable String branchId){


        try {

            MstBranch branch = mst_branchService.getBranchById(branchId);

            if(branch == null){
                throw new NotFoundException("Branch with Id " + branchId + " Not Found!");
            } else{
                return new ResponseEntity<>(branch, HttpStatus.OK);
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is a run-time error on the server.");

        }
    }

}
