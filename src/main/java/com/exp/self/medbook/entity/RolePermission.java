package com.exp.self.medbook.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ROLE_PERMISSION")
public class RolePermission {

    @EmbeddedId
    private RolePermissionId id;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "PERMISSION_ID", nullable = false)
    private Permission permission;
}
