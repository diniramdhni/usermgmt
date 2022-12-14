package com.usermgmt.service;

import com.usermgmt.dto.InsertBranchDTO;
import com.usermgmt.dto.UpdateBranchDTO;
import com.usermgmt.entity.MstBranch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MstBranchService {
    MstBranch insertBranch(InsertBranchDTO dto);


    MstBranch getBranchById(String branchId);

    MstBranch updateBranchById(UpdateBranchDTO updateDto, String id);

    void deleteById(String id);

    UpdateBranchDTO getBranchToUpdate(String id);

    Page<MstBranch> getAllBranch(Pageable pageable, String name, String id, String type, String address, String createdBy, String updatedBy);
}
