package com.innovared.innovared.dto;

import lombok.Data;

@Data
public class ProductionSummaryDTO {
    private String country;
    private Long totalEmployees;
    private Double totalGrossSales;
    private Double totalNetIncome;

    public ProductionSummaryDTO(String country, Long totalEmployees, Double totalGrossSales, Double totalNetIncome) {
        this.country = country;
        this.totalEmployees = totalEmployees;
        this.totalGrossSales = totalGrossSales;
        this.totalNetIncome = totalNetIncome;
    }
}
