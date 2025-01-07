package com.exp.self.medbook.repository;

import com.exp.self.medbook.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Permission findByPermissionName(String permissionName);
}
