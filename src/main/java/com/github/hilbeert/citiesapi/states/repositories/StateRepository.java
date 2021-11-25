package com.github.hilbeert.citiesapi.states.repositories;

import com.github.hilbeert.citiesapi.states.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long>{
}
