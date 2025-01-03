package com.exp.self.medbook.Mapper;

import com.exp.self.medbook.DTO.ReportDTO;
import com.exp.self.medbook.Entity.Report;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public abstract class ReportMapper {

    public abstract ReportDTO map(Report report);
    public abstract List<ReportDTO> map(List<Report> report);
}
