package com.exp.self.medbook.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name = "account_seq", sequenceName = "ACCOUNT_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "UUID", nullable = false, unique = true)
    private String uuid;

    @Column(name = "CREATE_DATE", nullable = false)
    private OffsetDateTime createDate;

    @Column(name = "FIO", nullable = false)
    private String fio;

    @Column(name = "PHONE", length = 20)
    private String phone;

    @Column(name = "EMAIL", length = 255)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ROLE_ID",
            referencedColumnName = "ID",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_ACCOUNT_ROLE_ID"))
    private Role role;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Application> applications;

}
