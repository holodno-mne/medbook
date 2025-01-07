package com.exp.self.medbook.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "PERMISSION")

public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SYSNAME", nullable = false, unique = true, length = 50)
    private String sysname;

    @Column(name = "DESCRIPTION")
    private String description;

}
