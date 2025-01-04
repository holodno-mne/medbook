package com.exp.self.medbook.mapper;

import com.exp.self.medbook.dto.ApplicationDTO;
import com.exp.self.medbook.entity.Application;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApplicationMapper {

    ApplicationDTO toApplicationDTO(Application application);


}
