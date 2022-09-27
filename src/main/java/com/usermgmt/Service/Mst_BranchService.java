package com.usermgmt.Service;

import com.usermgmt.Dto.Mst_BranchInsertDTO;
import com.usermgmt.Dto.UpdateBranchDTO;
import com.usermgmt.Entity.Mst_Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Mst_BranchService {
    Mst_Branch insertBranch(Mst_BranchInsertDTO dto);

    Page<Mst_Branch> getAllBranch(Pageable pageable, String name);

    Mst_Branch getBranchById(String branchId);

    Mst_Branch updateBranchById(UpdateBranchDTO updateDto, String id);

    void deleteById(String id);
}
