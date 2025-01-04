package com.exp.self.medbook.service;

import com.exp.self.medbook.dto.ApplicationDTO;
import com.exp.self.medbook.entity.Application;
import com.exp.self.medbook.mapper.ApplicationMapper;
import com.exp.self.medbook.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;

    public ApplicationDTO getReportById(Long id) {
        Application application = applicationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Application not found with id: " + id));
        return applicationMapper.toApplicationDTO(application);
    }
}
