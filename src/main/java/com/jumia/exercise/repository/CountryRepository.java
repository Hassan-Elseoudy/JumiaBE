package com.jumia.exercise.repository;

import com.jumia.exercise.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    /**
     * Find country with specific country code.
     * @param code country code
     * @return Country
     */
    Optional<Country> findCountryByCode(String code);
}
