package com.exp.self.medbook.Repository;

import com.exp.self.medbook.Entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {
    RolePermission findByPermissionName(String permissionName);
}
