package com.challenge8.Challenge8.Services;

import com.challenge8.Challenge8.Models.MeteorologicalData;
import com.challenge8.Challenge8.Repositories.MeteorologicalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MeteorologicalDataService {
        @Autowired
        private MeteorologicalDataRepository meteorologicalDataRepository;

        public Optional<MeteorologicalData> get(Integer id) {
            return meteorologicalDataRepository.findById(id.longValue());
        }

        public List<MeteorologicalData> list() {
            return meteorologicalDataRepository.findAll();
        }

        public MeteorologicalData create(MeteorologicalData meteorologicalData) {
            return meteorologicalDataRepository.save(meteorologicalData);
        }
        public void delete(Integer id) {
            meteorologicalDataRepository.deleteById(id.longValue());
        }

}