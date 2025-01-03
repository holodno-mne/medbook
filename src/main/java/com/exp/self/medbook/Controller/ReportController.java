package com.exp.self.medbook.Controller;

import com.exp.self.medbook.DTO.ReportDTO;
import com.exp.self.medbook.Service.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/report")
@Tag(name = "Заявленея", description = "Контроллер для работы с заявлениями")
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/list")
    @Operation(summary = "Процесс получения заявления")
    public List<ReportDTO> getListApplications() {
        return reportService.getListApplications();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Процесс получения заявления")
    public ResponseEntity<ReportDTO> getReportById(@PathVariable Long id) {
        ReportDTO reportDTO = reportService.getReportById(id);
        return ResponseEntity.ok(reportDTO);
    }
}
