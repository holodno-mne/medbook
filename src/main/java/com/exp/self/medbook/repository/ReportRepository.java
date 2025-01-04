package com.exp.self.medbook.repository;

import com.exp.self.medbook.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByUserId(Long id);
}
