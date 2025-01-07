package com.exp.self.medbook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class RolePermissionId {

    @Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "PERMISSION_ID")
    private Long PermissionId;
}
