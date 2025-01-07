package com.exp.self.medbook.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ACCOUNT_PERMISSION")
public class AccountPermission {

    @EmbeddedId
    private AccountPermissionId id;

    @ManyToOne
    @MapsId("accountID")
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    private Account account;

    @ManyToOne
    @MapsId("permissionID")
    @JoinColumn(name = "PERMISSION_ID", nullable = false)
    private Permission permission;
}
