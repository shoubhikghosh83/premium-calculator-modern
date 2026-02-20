package com.insurance.service;

import com.insurance.dto.InsuranceRequestDto;
import com.insurance.dto.InsuranceResponseDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InsuranceApplicationService {

    private final PremiumCalculationService premiumCalculationService;
    private final ApplicationIdGenerator applicationIdGenerator;

    public InsuranceApplicationService(PremiumCalculationService premiumCalculationService,
                                       ApplicationIdGenerator applicationIdGenerator) {
        this.premiumCalculationService = premiumCalculationService;
        this.applicationIdGenerator = applicationIdGenerator;
    }

    public InsuranceResponseDto processApplication(InsuranceRequestDto request) {
        int premium = premiumCalculationService.calculatePremium(
                request.getInsuranceType(),
                request.getCustomerName(),
                request.getCustomerAddress());

        InsuranceResponseDto response = new InsuranceResponseDto();
        response.setApplicationId(applicationIdGenerator.nextId());
        response.setCustomerName(request.getCustomerName());
        response.setCustomerAddress(request.getCustomerAddress());
        response.setInsuranceType(request.getInsuranceType().name());
        response.setCalculatedPremium(premium);
        response.setCreatedAt(LocalDateTime.now().toString());
        return response;
    }
}
