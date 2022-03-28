package com.challenge8.Challenge8.Models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@Builder
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    double lat;
    double lon;
    String city;
    String state;

    public Location() {
    }

    public Location(Long id, double lat, double lon, String city, String state) {
        this.id = id;
        this.lat = Double.parseDouble(String.format("%.4f", lat));
        this.lon = Double.parseDouble(String.format("%.4f", lon));
        this.city = city;
        this.state = state;
    }
}