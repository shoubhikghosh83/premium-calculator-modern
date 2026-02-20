package com.insurance.dto;

public class InsuranceResponseDto {

    private int applicationId;
    private String customerName;
    private String customerAddress;
    private String insuranceType;
    private int calculatedPremium;
    private String createdAt;

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public int getCalculatedPremium() {
        return calculatedPremium;
    }

    public void setCalculatedPremium(int calculatedPremium) {
        this.calculatedPremium = calculatedPremium;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
