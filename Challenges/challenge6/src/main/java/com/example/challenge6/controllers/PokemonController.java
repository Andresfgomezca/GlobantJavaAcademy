package com.example.challenge6.controllers;

import com.example.challenge6.models.Pokemon;
import com.example.challenge6.repository.TrainerRepository;
import com.example.challenge6.services.PokemonService;
import com.example.challenge6.services.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;
    @Autowired
    private TrainerRepository trainerRepository;


    @RequestMapping(value = "/pokemons", method = RequestMethod.GET)
    public ResponseEntity<Pokemon> list() {
        List<Pokemon> users = pokemonService.list();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/pokemon/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pokemon> userById(@PathVariable(value = "id") Integer id) {
        Optional<Pokemon> pokemon = pokemonService.get(id);
        if(pokemon.isPresent()){
            return new ResponseEntity(pokemon, HttpStatus.OK);
        }
        return new ResponseEntity("", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/pokemon", method = RequestMethod.POST)
    public ResponseEntity<Pokemon> create(@RequestBody Pokemon pokemon) {
        Pokemon userCreated = pokemonService.create(pokemon);
        return new ResponseEntity(userCreated, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/pokemon/{id}", method = RequestMethod.DELETE)
    public  void delete(@PathVariable("id") int itemId) {
    pokemonService.delete(itemId);
    }
}