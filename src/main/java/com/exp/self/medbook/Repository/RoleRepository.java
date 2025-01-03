package com.exp.self.medbook.Repository;

import com.exp.self.medbook.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    RoleRepository findByRoleName(String roleName);
}
