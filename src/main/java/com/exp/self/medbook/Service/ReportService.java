package com.exp.self.medbook.Service;

import com.exp.self.medbook.DTO.ReportDTO;
import com.exp.self.medbook.Entity.Report;
import com.exp.self.medbook.Mapper.ReportMapper;
import com.exp.self.medbook.Repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;

    public ReportDTO getReportById(Long id) {
        Report report = reportRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Report not found with id: " + id));
        return reportMapper.map(report);
    }

    public List<ReportDTO> getListApplications() {
        List<Report> reportList = reportRepository.findAll();
        return reportMapper.map(reportList);
    }
}
