package com.exp.self.medbook.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "permissions")

public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String permissionName;

    @ManyToMany(mappedBy = "rolePermissions")
    private Set<Role> roles;

    @ManyToMany(mappedBy = "rolePermissions")
    private Set<User> users;


}
