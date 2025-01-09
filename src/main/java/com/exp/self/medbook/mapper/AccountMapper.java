package com.exp.self.medbook.mapper;

import com.exp.self.medbook.dto.AccountDTO;
import com.exp.self.medbook.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {RoleMapper.class})
public interface AccountMapper {
    AccountDTO toAccountDTO(Account account);
}
