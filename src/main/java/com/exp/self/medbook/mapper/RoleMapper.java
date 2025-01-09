package com.exp.self.medbook.mapper;

import com.exp.self.medbook.dto.RoleDTO;
import com.exp.self.medbook.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {
    RoleDTO toRoleDTO(Role role);
}
