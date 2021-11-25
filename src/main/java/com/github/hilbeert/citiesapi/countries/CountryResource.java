package com.github.hilbeert.citiesapi.countries;

import com.github.hilbeert.citiesapi.countries.Country;
import com.github.hilbeert.citiesapi.countries.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/countries")
public class CountryResource {

    @Autowired
    private CountryRepository repository;

    /*
    Mesma coisa que @Autowired

    public CountryResource(CountryRepository repository) {
        this.repository = repository
    }*/

    @GetMapping
    public Page<Country> countries(Pageable page){
        return repository.findAll(page);
    }

    /* Método sem paginação, má prática REST
    *
    @GetMapping
    public List<Country> countries(){
        return repository.findAll();
    }
    *
    * */

    /*
    () - 🚫
    {} - 👌
    @GetMapping("/(id)")
    public Optional<Country> getOne(@PathVariable Long id){
        return repository.findById(id);
    }
    */

    /*
    Sem tratamento de ERRO
    @GetMapping("/{id}")
    public Country getOne(@PathVariable Long id){
        Optional<Country> optional = repository.findById(id);
        return optional.get();
    }*/

    // Erro 404 se notFound
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<Country> optional = repository.findById(id);

        return (optional.isPresent()) ? ResponseEntity.ok().body(optional.get()) : ResponseEntity.notFound().build();
    }
}
