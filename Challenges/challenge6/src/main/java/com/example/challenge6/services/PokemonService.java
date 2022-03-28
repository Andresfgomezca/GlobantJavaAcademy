package com.example.challenge6.services;

import com.example.challenge6.models.Pokemon;
import com.example.challenge6.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public Optional<Pokemon> get(Integer id) {
        return pokemonRepository.findById(id.longValue());
    }

    public List<Pokemon> list() {
        return pokemonRepository.findAll();
    }

    public Pokemon create(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public void delete(Integer id){pokemonRepository.deleteById(id.longValue());}
}
