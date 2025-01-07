package com.exp.self.medbook.dto;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleDTO {
    private String name;
    private Set<String> permissions;
}
