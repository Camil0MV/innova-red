package com.innovared.innovared.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntrepreneurshipRequest {

    @NotBlank(message = "El nombre del emprendimiento es obligatorio")
    private String name;

    @NotBlank(message = "El tipo de emprendimiento es obligatorio")
    private String type;

    private String description;

    @NotBlank(message = "El país es obligatoria")
    private String country;

    @NotBlank(message = "El departamento o provincia es obligatorio/a")
    private String departmentProvince;

    @NotBlank(message = "La ciudad es obligatoria")
    private String city;

    @NotBlank(message = "El número de empleados es obligatorio")
    private Integer employees;
    
    @NotBlank(message = "El número de ventas brutas es obligatorio")
    private Double grossSales;
    
    @NotBlank(message = "El número de ganancias netas es obligatorio")
    private Double netIncome;
    
    @NotBlank(message = "El consumo de energía en kW es obligatorio")
    private Double energyConsumptionKw;

    @NotNull(message = "El ID del emprendedor es obligatorio")
    private String personId;
}
