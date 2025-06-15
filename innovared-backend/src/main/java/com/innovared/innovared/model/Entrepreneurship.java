package com.innovared.innovared.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "entrepreneurships")
public class Entrepreneurship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String type;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, length = 100)
    private String country;

    @Column(nullable = false, length = 100)
    private String departmentProvince;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "employees")
    private Integer employees;

    @Column(name = "gross_sales")
    private Double grossSales;

    @Column(name = "net_income")
    private Double netIncome;

    @Column(name = "energy_consumption_kw")
    private Double energyConsumptionKw;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
}
