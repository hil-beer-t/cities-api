package com.github.hilbeert.citiesapi.states;

import com.github.hilbeert.citiesapi.states.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long>{
}
