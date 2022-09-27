package com.usermgmt.Repository;

import com.usermgmt.Entity.Mst_Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Mst_BranchRepository extends JpaRepository<Mst_Branch, String> {

    @Query("""
            SELECT br
            FROM Mst_Branch br
            WHERE UPPER(br.name) LIKE %:name%
            """)
    Page<Mst_Branch> findAllBranch(Pageable page,
                                  @Param("name") String name);
}
