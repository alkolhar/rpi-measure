package com.example.rpimeasure.sensorvalues;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SensorValueRepository extends JpaRepository<SensorValue, Integer> {

    Optional<SensorValue> findById(Integer id);

    // Get the newest record by sensor id in database
    Optional<SensorValue> findTopBySensorIdOrderByIdDesc(Integer sensorId);

    List<SensorValue> findAll();

    long countBySensorId(Integer sensorId);
}
