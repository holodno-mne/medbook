package com.exp.self.medbook.Service;

import com.exp.self.medbook.DTO.ReportDTO;
import com.exp.self.medbook.Entity.Report;
import com.exp.self.medbook.Mapper.ReportMapper;
import com.exp.self.medbook.Repository.ReportRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository){
        this. reportRepository = reportRepository;
    }

    public ReportDTO getReportById(Long id){
        Report report = reportRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Report not found with id: " + id));
        return ReportMapper.toDTO(report);
    }
}
