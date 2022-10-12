package com.usermgmt.service;

import com.usermgmt.dto.InsertBranchDTO;
import com.usermgmt.dto.UpdateBranchDTO;
import com.usermgmt.entity.MstBranch;
import com.usermgmt.repository.MstBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;

@Service
public class MstBranchServiceImpl implements MstBranchService {

    @Autowired
    private MstBranchRepository mst_branchRepository;

    @Override
    public MstBranch insertBranch(InsertBranchDTO dto) {

        MstBranch mst_branch = new MstBranch(
                dto.getId(),
                dto.getName(),
                dto.getType(),
                dto.getAddress(),
                dto.isFlag_active(),
                LocalDateTime.now(),
                dto.getCreated_by(),
                null,
                null
        );
       mst_branchRepository.save(mst_branch);
        System.out.println("mst branch: "+mst_branch);
       return mst_branch;
    }

    @Override
    public Page<MstBranch> getAllBranch(Pageable pageable, String name, String id, String type, String address, String createdBy, String updatedBy) {

        String name2 = name.toUpperCase(Locale.ROOT);

        Page<MstBranch> grid = mst_branchRepository.findAllBranch(pageable, name2, id, type, address, createdBy, updatedBy);

        System.out.println("ini grid branch service "+ grid);
        return grid;
    }

    @Override
    public MstBranch getBranchById(String branchId) {
        Optional<MstBranch> mst_branchOptional = mst_branchRepository.findById(branchId);

        MstBranch temp = null;

        if (mst_branchOptional.isPresent()){
            temp = mst_branchOptional.get();
        }

        return temp;
    }

    @Override
    public MstBranch updateBranchById(UpdateBranchDTO updateDto, String id) {
        MstBranch branchById = getBranchById(id);

        if (branchById != null){
            branchById.setName(updateDto.getName());
            branchById.setType(updateDto.getType());
            branchById.setAddress(updateDto.getAddress());
            branchById.setUpdatedDate(LocalDateTime.now());
            branchById.setUpdatedBy(updateDto.getUpdate_by());
        }

        mst_branchRepository.save(branchById);

        return branchById;
    }

    @Override
    public void deleteById(String id) {
        mst_branchRepository.deleteById(id);
    }

    @Override
    public UpdateBranchDTO getBranchToUpdate(String id) {

        MstBranch branchTemp = getBranchById(id);

        UpdateBranchDTO updateBranchDTO = new UpdateBranchDTO(
                branchTemp.getId(),
                branchTemp.getName(),
                branchTemp.getType(),
                branchTemp.getAddress(),
                branchTemp.isFlagActive(),
                branchTemp.getUpdatedBy()
        );

        return updateBranchDTO;
    }
}
