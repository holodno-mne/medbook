package com.exp.self.medbook.service;

import com.exp.self.medbook.dto.ReportDTO;
import com.exp.self.medbook.entity.Report;
import com.exp.self.medbook.mapper.ReportMapper;
import com.exp.self.medbook.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;

    public ReportDTO getReportById(Long id){
        Report report = reportRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Report not found with id: " + id));
        return reportMapper.toReportDTO(report);
    }
}
