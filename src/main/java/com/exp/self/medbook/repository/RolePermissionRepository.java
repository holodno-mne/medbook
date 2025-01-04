package com.exp.self.medbook.repository;

import com.exp.self.medbook.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {
    RolePermission findByPermissionName(String permissionName);
}
