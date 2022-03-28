package com.challenge8.Challenge8.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "mdata")
@NoArgsConstructor
@AllArgsConstructor
public class MeteorologicalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column
    String date;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    Float temperature1;
    Float temperature2;
    Float temperature3;
    Float temperature4;
}

