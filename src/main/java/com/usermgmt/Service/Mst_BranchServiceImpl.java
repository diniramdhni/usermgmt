package com.usermgmt.Service;

import com.usermgmt.Dto.Mst_BranchInsertDTO;
import com.usermgmt.Dto.UpdateBranchDTO;
import com.usermgmt.Entity.Mst_Branch;
import com.usermgmt.Repository.Mst_BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class Mst_BranchServiceImpl implements Mst_BranchService{

    @Autowired
    private Mst_BranchRepository mst_branchRepository;

    @Override
    public Mst_Branch insertBranch(Mst_BranchInsertDTO dto) {
        Mst_Branch mst_branch = new Mst_Branch(
                dto.getId(),
                dto.getName(),
                dto.getType(),
                dto.getAddress(),
                dto.isFlag_active(),
                dto.getCreated_by(),
                dto.getUpdate_by()
        );
       mst_branchRepository.save(mst_branch);
        System.out.println("mst branch: "+mst_branch);
       return mst_branch;
    }

    @Override
    public Page<Mst_Branch> getAllBranch(Pageable page, String name) {

        String name2 = name.toUpperCase(Locale.ROOT);

        Page<Mst_Branch> grid = mst_branchRepository.findAllBranch(page, name2);
        return grid;
    }

    @Override
    public Mst_Branch getBranchById(String branchId) {
        Optional<Mst_Branch> mst_branchOptional = mst_branchRepository.findById(branchId);

        Mst_Branch temp = null;

        if (mst_branchOptional.isPresent()){
            temp = mst_branchOptional.get();
        }

        System.out.println(temp);

        return temp;
    }

    @Override
    public Mst_Branch updateBranchById(UpdateBranchDTO updateDto, String id) {
        Mst_Branch branchById = getBranchById(id);

        if (branchById != null){
            branchById.setName(updateDto.getName());
            branchById.setType(updateDto.getType());
            branchById.setAddress(updateDto.getAddress());
            branchById.setCreated_by(updateDto.getCreated_by());
            branchById.setUpdate_by(branchById.getUpdate_by());
        }

        System.out.println(branchById);
        mst_branchRepository.save(branchById);

        return branchById;
    }

    @Override
    public void deleteById(String id) {
        mst_branchRepository.deleteById(id);
    }
}
