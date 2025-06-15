package com.innovared.innovared.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.innovared.innovared.dto.CountryCountDTO;
import com.innovared.innovared.dto.CountryPercentageDTO;
import com.innovared.innovared.dto.EnergyConsumptionDTO;
import com.innovared.innovared.dto.EntrepreneurshipRequest;
import com.innovared.innovared.dto.ProductionSummaryDTO;
import com.innovared.innovared.dto.TypeCountryCountDTO;
import com.innovared.innovared.exception.ResourceNotFoundException;
import com.innovared.innovared.model.Entrepreneurship;
import com.innovared.innovared.model.Person;
import com.innovared.innovared.repository.EntrepreneurshipRepository;
import com.innovared.innovared.repository.PersonRepository;

@Service
public class EntrepreneurshipService {
    private final EntrepreneurshipRepository repository;
    private final PersonRepository personRepository;

    public EntrepreneurshipService(EntrepreneurshipRepository repository, PersonRepository personRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
    }

    public Entrepreneurship create(EntrepreneurshipRequest request) {
        Person person = personRepository.findById(request.getPersonId())
            .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada"));

        Entrepreneurship e = Entrepreneurship.builder()
            .name(request.getName())
            .type(request.getType())
            .description(request.getDescription())
            .country(request.getCountry())
            .departmentProvince(request.getDepartmentProvince())
            .city(request.getCity())
            .startDate(LocalDate.now())
            .employees(request.getEmployees())
            .grossSales(request.getGrossSales())
            .netIncome(request.getNetIncome())
            .energyConsumptionKw(request.getEnergyConsumptionKw())
            .person(person)
            .build();

        return repository.save(e);
    }

    public Entrepreneurship update(Long id, Entrepreneurship updated) {
        Entrepreneurship existing = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Emprendimiento no encontrado"));

        existing.setName(updated.getName());
        existing.setType(updated.getType());
        existing.setEmployees(updated.getEmployees());
        existing.setGrossSales(updated.getGrossSales());
        existing.setNetIncome(updated.getNetIncome());
        existing.setEnergyConsumptionKw(updated.getEnergyConsumptionKw());

        return repository.save(existing);
    }

    public void delete(Long id) {
        Entrepreneurship e = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Emprendimiento no encontrado"));
        repository.delete(e);
    }

    public List<Entrepreneurship> findByCity(String city) {
        return repository.findByCity(city);
    }

    public List<TypeCountryCountDTO> getProductionByTypeAndRegion() {
    return repository.countByTypeAndCountry();
    }

    public Map<String, Double> getPercentageByRegion() {
        List<CountryPercentageDTO> result = repository.getPercentageByCountry();
        return result.stream().collect(Collectors.toMap(
            CountryPercentageDTO::getCountry,
            CountryPercentageDTO::getPercentage
        ));
    }

    public List<CountryCountDTO> getTopCountries(int limit) {
        return repository.findTopCountries(PageRequest.of(0, limit));
    }

    public List<Entrepreneurship> getByType(String type) {
        return repository.findByType(type);
    }

    public List<ProductionSummaryDTO> getProductionSummary() {
        return repository.getProductionSummaryByCountry().stream().map(r ->
            new ProductionSummaryDTO(
                (String) r[0],
                ((Number) r[1]).longValue(),
                ((Number) r[2]).doubleValue(),
                ((Number) r[3]).doubleValue()
            )
        ).collect(Collectors.toList());
    }

    public List<EnergyConsumptionDTO> getEnergyConsumption() {
        return repository.getEnergyConsumptionByCountry().stream().map(r ->
            new EnergyConsumptionDTO(
                (String) r[0],
                ((Number) r[1]).doubleValue()
            )
        ).collect(Collectors.toList());
    }
}
