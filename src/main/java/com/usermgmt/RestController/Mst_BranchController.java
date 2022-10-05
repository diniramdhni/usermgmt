package com.usermgmt.RestController;

import com.usermgmt.Dto.Mst_BranchInsertDTO;
import com.usermgmt.Dto.UpdateBranchDTO;
import com.usermgmt.Entity.Mst_Branch;
import com.usermgmt.NotFoundException;
import com.usermgmt.Service.Mst_BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/branch")
public class Mst_BranchController {

    @Autowired
    private Mst_BranchService mst_branchService;

    private final Integer maxRows = 10;

    @PostMapping("/add")
    public ResponseEntity<Object> addBranch(@Valid @RequestBody Mst_BranchInsertDTO dto){
        try {
            System.out.println("insert branch addd");
            Mst_Branch mst_branch = mst_branchService.insertBranch(dto);
            return new ResponseEntity<>(mst_branch, HttpStatus.CREATED);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is a run-time error on the server.");

        }
    }

    @GetMapping("/list")
    public ResponseEntity<Object> listBranch(@RequestParam(defaultValue = "1") Integer page,
                                                       @RequestParam(defaultValue = "") String name){

        try {
            Pageable pageable = PageRequest.of(page - 1, maxRows, Sort.by("id"));

            Page<Mst_Branch> grid = mst_branchService.getAllBranch(pageable, name);

            return new ResponseEntity<>(grid, HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is a run-time error on the server.");

        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateBranch(@RequestBody UpdateBranchDTO updateDto,
                                                   @RequestParam(required = true)String id){

        //findbyid
        try {
            Mst_Branch branchById = mst_branchService.getBranchById(id);

            if (branchById != null){
                Mst_Branch branchUpdate = mst_branchService.updateBranchById( updateDto, id);

                return new ResponseEntity<>(branchUpdate, HttpStatus.ACCEPTED);
            }else{

                throw new NotFoundException("Branch with Id " + id + " Not Found!");
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is a run-time error on the server.");

        }

    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteBranch(@RequestParam(required = true) String id){
        try {
            Mst_Branch mst_branch = mst_branchService.getBranchById(id);
            if(mst_branch == null){
                throw new NotFoundException("Branch with Id " + id + " Not Found!");
            } else{
                mst_branchService.deleteById(id);
                return new ResponseEntity<>("Succes Delete Mst_Branch With Id " + id, HttpStatus.OK);
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is a run-time error on the server.");

        }
    }



    @GetMapping("/{branchId}")
    public ResponseEntity<Object> searchBranchId(@PathVariable String branchId){


        try {

            Mst_Branch branch = mst_branchService.getBranchById(branchId);

            if(branch == null){
                throw new NotFoundException("Branch with Id " + branchId + " Not Found!");
            } else{
                return new ResponseEntity<>(branch, HttpStatus.FOUND);
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is a run-time error on the server.");

        }
    }

}
