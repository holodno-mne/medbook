package com.exp.self.medbook.DTO;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String nameDTO;
    private String emailDTO;
    private String roleNameDTO;
    private Set<String> permissionsDTO;
}
