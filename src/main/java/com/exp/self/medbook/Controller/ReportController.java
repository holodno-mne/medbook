package com.exp.self.medbook.Controller;

import com.exp.self.medbook.DTO.ReportDTO;
import com.exp.self.medbook.Service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/{id}")
    public ResponseEntity<ReportDTO> getReportById(@PathVariable Long id) {
        ReportDTO reportDTO = reportService.getReportById(id);
        return ResponseEntity.ok(reportDTO);
    }
}
