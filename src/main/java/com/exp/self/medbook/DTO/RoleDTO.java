package com.exp.self.medbook.DTO;

import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RoleDTO {
    private String roleName;
    private Set<String> permissions;
}
