package com.example.challenge6.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "pokemon")
@Data
@Table(name="pokemons")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableId;
    //Incremental ID

    private String name;
    private String nickName;
    private String type;
    private String gender;
    @ManyToOne()
    @JoinColumn(name = "trainer_Id", referencedColumnName = "trainerId", nullable = false)
    private Trainer trainer;





}

