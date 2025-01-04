package com.exp.self.medbook.repository;

import com.exp.self.medbook.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    RoleRepository findByRoleName(String roleName);
}
