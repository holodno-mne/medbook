package com.exp.self.medbook.Mapper;

import com.exp.self.medbook.DTO.ReportDTO;
import com.exp.self.medbook.Entity.Report;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public abstract class ReportMapper {

    public abstract ReportDTO map(Report report);
}
