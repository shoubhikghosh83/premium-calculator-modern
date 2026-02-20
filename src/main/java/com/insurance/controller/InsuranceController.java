package com.insurance.controller;

import com.insurance.dto.InsuranceRequestDto;
import com.insurance.dto.InsuranceResponseDto;
import com.insurance.service.InsuranceApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/insurance")
public class InsuranceController {

    private final InsuranceApplicationService insuranceApplicationService;

    public InsuranceController(InsuranceApplicationService insuranceApplicationService) {
        this.insuranceApplicationService = insuranceApplicationService;
    }

    @PostMapping
    public ResponseEntity<InsuranceResponseDto> createApplication(
            @Valid @RequestBody InsuranceRequestDto request) {
        InsuranceResponseDto response = insuranceApplicationService.processApplication(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
