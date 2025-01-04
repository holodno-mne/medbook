package com.exp.self.medbook.mapper;

import com.exp.self.medbook.dto.ReportDTO;
import com.exp.self.medbook.entity.Report;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReportMapper {

    ReportDTO toReportDTO(Report report);


//    public static ReportDTO toDTO(Report report){
//        ReportDTO reportDTO = new ReportDTO();
//        reportDTO.setId(report.getId());
//        reportDTO.setTitle(report.getTitle());
//        reportDTO.setDescription(report.getDescription());
//        return reportDTO;
//    }


}
