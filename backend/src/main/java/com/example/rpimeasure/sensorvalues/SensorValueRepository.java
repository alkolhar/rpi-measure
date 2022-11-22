package com.example.rpimeasure.sensorvalues;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorValueRepository extends JpaRepository<SensorValue, Integer> {

    // Get the newest record by sensor id in database
    Optional<SensorValue> findTopBySensorIdOrderByIdDesc(Integer sensorId);

    long countBySensorId(Integer sensorId);
}
