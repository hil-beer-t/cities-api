package com.github.hilbeert.citiesapi.countries.repository;

import com.github.hilbeert.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {

}
