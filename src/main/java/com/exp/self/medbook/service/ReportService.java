package com.exp.self.medbook.service;

import com.exp.self.medbook.dto.ReportDTO;
import com.exp.self.medbook.entity.Report;
import com.exp.self.medbook.mapper.ReportMapper;
import com.exp.self.medbook.repository.ReportRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository){
        this. reportRepository = reportRepository;
    }

    public ReportDTO getReportById(Long id){
        Report report = reportRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Report not found with id: " + id));
        return ReportMapper.toReportDTO(report);
    }
}
