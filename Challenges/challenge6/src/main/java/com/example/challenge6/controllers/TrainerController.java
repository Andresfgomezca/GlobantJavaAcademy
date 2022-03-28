package com.example.challenge6.controllers;

import com.example.challenge6.models.Pokemon;
import com.example.challenge6.models.Trainer;

import com.example.challenge6.services.PokemonService;
import com.example.challenge6.services.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class TrainerController {
    @Autowired
    private TrainerService trainerService;
    @Autowired
    private PokemonService pokemonService;


    @RequestMapping(value = "/trainers", method = RequestMethod.GET)
    public ResponseEntity<Trainer> list() {
        List<Trainer> users = trainerService.list();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/trainer/{id}", method = RequestMethod.GET)
    public ResponseEntity<Trainer> userById(@PathVariable(value = "id") Integer id) {
        Optional<Trainer> trainer = trainerService.get(id);
        if(trainer.isPresent()){
            return new ResponseEntity(trainer, HttpStatus.OK);
        }
        return new ResponseEntity("", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/trainer/{id}/pokemons-catched", method = RequestMethod.GET)
    public ResponseEntity<Trainer> getPokemons(@PathVariable(value = "id") Integer id) {
            List<Pokemon> pokemonsCatched = trainerService.getPokemons(id);
            return new ResponseEntity(pokemonsCatched, HttpStatus.OK);
    }

    @RequestMapping(value = "/trainer", method = RequestMethod.POST)
    public ResponseEntity<Pokemon> create(@RequestBody Trainer trainer) {
        Trainer userCreated = trainerService.create(trainer);
        return new ResponseEntity(userCreated, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/trainer/{id}", method = RequestMethod.DELETE)
    public  void delete(@PathVariable("id") int trainerId) {
        trainerService.delete(trainerId);
    }


}