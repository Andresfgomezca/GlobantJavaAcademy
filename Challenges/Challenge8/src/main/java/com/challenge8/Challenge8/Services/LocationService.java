package com.challenge8.Challenge8.Services;

import com.challenge8.Challenge8.Models.Location;
import com.challenge8.Challenge8.Repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;
    public Optional<Location> get(Long id) {
        return locationRepository.findById(id.longValue());
    }
    public List<Location> list() {
        return locationRepository.findAll();
    }
    public Location create(Location location) {
        return locationRepository.save(location);
    }

    public void delete(Integer id) {
        locationRepository.deleteById(id.longValue());
    }
}
