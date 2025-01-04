package com.exp.self.medbook.mapper;

import com.exp.self.medbook.dto.UserDTO;
import com.exp.self.medbook.entity.User;

import java.util.stream.Collectors;

public class UserMapper {
    public static UserDTO toDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setNameDTO(user.getName());
        userDTO.setEmailDTO(user.getEmail());
        userDTO.setRoleNameDTO(user.getRole().getRoleName());
        userDTO.setPermissionsDTO(user.getRolePermissions().stream().map(permission -> permission.getPermissionName()).collect(Collectors.toSet()));
        return userDTO;
    }
}
