package com.exp.self.medbook.dto;

import com.exp.self.medbook.entity.Application;
import com.exp.self.medbook.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountDTO {
    private Long id;
    private String createDate;
    private String fio;
    private String phone;
    private String email;
    private Role role;
    private List<Application> applicationList;
}
