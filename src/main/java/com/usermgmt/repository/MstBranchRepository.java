package com.usermgmt.repository;

import com.usermgmt.entity.MstBranch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MstBranchRepository extends JpaRepository<MstBranch, String> {

    @Query("""
            SELECT br
            FROM MstBranch br
            WHERE UPPER(br.name) LIKE %:name%
            """)
    Page<MstBranch> findAllBranch(Pageable page,
                                  @Param("name") String name);
}
