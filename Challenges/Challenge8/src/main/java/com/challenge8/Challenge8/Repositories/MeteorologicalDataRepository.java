package com.challenge8.Challenge8.Repositories;

import com.challenge8.Challenge8.Models.MeteorologicalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MeteorologicalDataRepository extends JpaRepository<MeteorologicalData,Long> {
}
