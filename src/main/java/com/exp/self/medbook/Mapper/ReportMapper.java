package com.exp.self.medbook.Mapper;

import com.exp.self.medbook.DTO.ReportDTO;
import com.exp.self.medbook.Entity.Report;

public class ReportMapper {

    public static ReportDTO toDTO(Report report){
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setId(report.getId());
        reportDTO.setTitle(report.getTitle());
        reportDTO.setDescription(report.getDescription());
        return reportDTO;
    }


}
