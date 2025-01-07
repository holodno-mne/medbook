package com.exp.self.medbook.service;

import com.exp.self.medbook.dto.ApplicationDTO;
import com.exp.self.medbook.entity.Account;
import com.exp.self.medbook.entity.Application;
import com.exp.self.medbook.mapper.ApplicationMapper;
import com.exp.self.medbook.repository.AccountRepository;
import com.exp.self.medbook.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;
    private final AccountRepository accountRepository;

    public ApplicationDTO getReportById(Long id) {
        Application application = applicationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Application not found with id: " + id));
        return applicationMapper.toApplicationDTO(application);
    }

    public Application createApplication(Long accountId){
        Account account = accountRepository.findById(accountId).orElseThrow(()-> new RuntimeException("Account not found"));

        Application application = new Application();
        application.setAccount(account);
        application.setCreateDate(OffsetDateTime.now());
        application.setDeleted(false);

        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications(){
        return applicationRepository.findAll();
    }
}
