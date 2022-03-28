package com.example.challenge6.models;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@Data
@Table(name="trainers")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trainerId;
    private String lastName;
    private String firstName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainer")
    @JoinColumn(name = "table_Id")
    private List<Pokemon> pokemonsCatched= new ArrayList<>();

    public void addPokemon(Pokemon pokemon) {
        pokemonsCatched.add(pokemon);
        pokemon.setTrainer(this);
    }

    public void removePokemon(Pokemon pokemon) {
        pokemonsCatched.remove(pokemon);
        pokemon.setTrainer(null);
    }

   }
