package com.exp.self.medbook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class AccountPermissionId implements Serializable {

    @Column(name = "ACCOUNT_ID")
    private Long accountId;

    @Column(name = "PERMISSION_ID")
    private Long permissionId;

}
