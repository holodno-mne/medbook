package com.exp.self.medbook.controller;

import com.exp.self.medbook.dto.ApplicationDTO;
import com.exp.self.medbook.entity.Application;
import com.exp.self.medbook.service.ApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/application")
@Tag(name = "Новости", description = "Контроллер для работы с новостями")
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping()
    public ResponseEntity<ApplicationDTO> getApplicationById(@RequestParam Long id) {
        ApplicationDTO applicationDTO = applicationService.getApplicationById(id);
        return ResponseEntity.ok(applicationDTO);
    }

    @PostMapping("/save")
    @Operation(summary = "Сохранение новой новости")
    public ResponseEntity<Application> createApplication(@RequestParam Long accountId){
        Application application = applicationService.createApplication(accountId);
        return ResponseEntity.status(HttpStatus.CREATED).body(application);
    }

    @GetMapping("/get/list")
    public List<Application> getAllApplications(){
        return applicationService.getAllApplications();
    }
}
