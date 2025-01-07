package com.exp.self.medbook.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SYSNAME", nullable = false, unique = true)
    private String sysname;

    @Column(name = "DESCRIPTION", length = 1000)
    private String description;

    @OneToOne(mappedBy = "role")
    private Account account;

}
