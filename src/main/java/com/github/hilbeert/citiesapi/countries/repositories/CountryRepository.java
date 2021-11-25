package com.github.hilbeert.citiesapi.countries.repositories;

import com.github.hilbeert.citiesapi.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {

}
