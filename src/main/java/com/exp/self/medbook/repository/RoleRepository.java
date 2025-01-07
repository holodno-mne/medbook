package com.exp.self.medbook.repository;

import com.exp.self.medbook.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    RoleRepository findBySysname(String sysname);
}
