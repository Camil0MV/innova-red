package com.innovared.innovared.repository;

import com.innovared.innovared.dto.CountryCountDTO;
import com.innovared.innovared.dto.CountryPercentageDTO;
import com.innovared.innovared.dto.TypeCountryCountDTO;
import com.innovared.innovared.model.Entrepreneurship;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EntrepreneurshipRepository extends JpaRepository<Entrepreneurship, Long> {
    List<Entrepreneurship> findByCity(String city);

    @Query("SELECT e FROM Entrepreneurship e WHERE e.type = :type")
    List<Entrepreneurship> findByType(@Param("type") String type);

    @Query(value = "SELECT city, COUNT(*) AS total FROM entrepreneurships GROUP BY city", nativeQuery = true)
    List<Object[]> countByCity();

    @Query("SELECT e.type AS type, e.country AS country, COUNT(e) AS total " +
           "FROM Entrepreneurship e GROUP BY e.type, e.country")
    List<TypeCountryCountDTO> countByTypeAndCountry();

    @Query("SELECT e.country AS country, COUNT(e) * 1.0 / (SELECT COUNT(e2) FROM Entrepreneurship e2) AS percentage " +
       "FROM Entrepreneurship e GROUP BY e.country")
    List<CountryPercentageDTO> getPercentageByCountry();

    @Query("SELECT e.country AS country, COUNT(e) AS total " +
       "FROM Entrepreneurship e GROUP BY e.country ORDER BY total DESC")
    List<CountryCountDTO> findTopCountries(PageRequest pageable);

    @Query("SELECT p.departmentProvince, SUM(e.employees), SUM(e.grossSales), SUM(e.netIncome) " +
       "FROM Entrepreneurship e JOIN e.person p GROUP BY p.departmentProvince")
    List<Object[]> getProductionSummaryByCountry();

    @Query("SELECT p.departmentProvince, SUM(e.energyConsumptionKw) " +
       "FROM Entrepreneurship e JOIN e.person p GROUP BY p.departmentProvince")
    List<Object[]> getEnergyConsumptionByCountry();
}
