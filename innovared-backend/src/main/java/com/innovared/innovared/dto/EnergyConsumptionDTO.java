package com.innovared.innovared.dto;

import lombok.Data;

@Data
public class EnergyConsumptionDTO {
    private String country;
    private Double totalEnergyKw;

    public EnergyConsumptionDTO(String country, Double totalEnergyKw) {
        this.country = country;
        this.totalEnergyKw = totalEnergyKw;
    }
}
