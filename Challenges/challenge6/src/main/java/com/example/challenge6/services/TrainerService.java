package com.example.challenge6.services;

import com.example.challenge6.models.Pokemon;
import com.example.challenge6.models.Trainer;
import com.example.challenge6.repository.PokemonRepository;
import com.example.challenge6.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

        @Autowired
        private TrainerRepository trainerRepository;

        @Autowired
        private PokemonRepository pokemonRepository;

        public Optional<Trainer> get(Integer id) {
            return trainerRepository.findById(id.longValue());
        }

        public List<Pokemon> getPokemons(Integer id) {
        return trainerRepository.getById(id.longValue()).getPokemonsCatched();
        }

        public List<Trainer> list() {
            return trainerRepository.findAll();
        }

        public Trainer create(Trainer trainer) {
            return trainerRepository.save(trainer);
        }

        public void delete(Integer id){trainerRepository.deleteById(id.longValue());}
}
