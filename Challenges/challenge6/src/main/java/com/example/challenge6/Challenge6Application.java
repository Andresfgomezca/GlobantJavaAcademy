package com.example.challenge6;

import com.example.challenge6.controllers.PokemonController;
import com.example.challenge6.models.Pokemon;
import com.example.challenge6.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Challenge6Application {
	@Autowired
	PokemonController pokemonController;
	public static void main(String[] args) {
		SpringApplication.run(Challenge6Application.class, args);

	}
	@Bean
	public CommandLineRunner run(PokemonRepository pokemonRepository) throws Exception {
		return (String[] args) -> {



		};
	}

}
