package com.insurance.service;

import com.insurance.model.InsuranceType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PremiumCalculationService {

    private static final BigDecimal AUTO_BASE = new BigDecimal("5000");
    private static final BigDecimal MEDICAL_BASE = new BigDecimal("7000");
    private static final BigDecimal HOUSE_BASE = new BigDecimal("10000");
    private static final BigDecimal DISCOUNT_FACTOR = new BigDecimal("0.95");
    private static final BigDecimal SURCHARGE_FACTOR = new BigDecimal("1.10");
    private static final int NAME_LENGTH_THRESHOLD = 10;

    public int calculatePremium(InsuranceType type, String customerName, String customerAddress) {
        BigDecimal premium = getBasePremium(type);

        if (customerName.length() > NAME_LENGTH_THRESHOLD) {
            premium = premium.multiply(DISCOUNT_FACTOR);
        }

        if (customerAddress.contains("Metro")) {
            premium = premium.multiply(SURCHARGE_FACTOR);
        }

        return premium.intValue();
    }

    private BigDecimal getBasePremium(InsuranceType type) {
        return switch (type) {
            case AUTO -> AUTO_BASE;
            case MEDICAL -> MEDICAL_BASE;
            case HOUSE -> HOUSE_BASE;
        };
    }
}
