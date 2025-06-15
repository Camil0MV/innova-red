package com.innovared.innovared.controller;

import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innovared.innovared.dto.CountryCountDTO;
import com.innovared.innovared.dto.EnergyConsumptionDTO;
import com.innovared.innovared.dto.EntrepreneurshipRequest;
import com.innovared.innovared.dto.ProductionSummaryDTO;
import com.innovared.innovared.dto.TypeCountryCountDTO;
import com.innovared.innovared.model.Entrepreneurship;
import com.innovared.innovared.service.EntrepreneurshipService;

@RestController
@RequestMapping("/api/entrepreneurships")
public class EntrepreneurshipController {

    private final EntrepreneurshipService service;

    public EntrepreneurshipController(EntrepreneurshipService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Entrepreneurship> create(@Valid @RequestBody EntrepreneurshipRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrepreneurship> update(@PathVariable Long id, @RequestBody Entrepreneurship updated) {
        return ResponseEntity.ok(service.update(id, updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/city/{city}")
    public List<Entrepreneurship> findByCity(@PathVariable  String city) {
        return service.findByCity(city);
    }

    @GetMapping("/stats/type-region")
    public List<TypeCountryCountDTO> getProductionByTypeAndCountry() {
        return service.getProductionByTypeAndRegion();
    }

    @GetMapping("/percentage")
    public Map<String, Double> getPercentageByCountry() {
        return service.getPercentageByRegion();
    }

    @GetMapping("/stats/top-countries")
    public List<CountryCountDTO> getTopCountries(@RequestParam(defaultValue = "10") int limit) {
        return service.getTopCountries(limit);
    }

    @GetMapping("/filter/type")
    public List<Entrepreneurship> getByType(@RequestParam String type) {
        return service.getByType(type);
    }

    @GetMapping("/stats/production-summary")
    public List<ProductionSummaryDTO> getProductionSummary() {
        return service.getProductionSummary();
    }

    @GetMapping("/stats/energy-consumption")
    public List<EnergyConsumptionDTO> getEnergyConsumption() {
        return service.getEnergyConsumption();
    }
}
