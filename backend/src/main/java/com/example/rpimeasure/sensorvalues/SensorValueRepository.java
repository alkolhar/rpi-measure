package com.example.rpimeasure.sensorvalues;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SensorValueRepository extends JpaRepository<SensorValue, Integer> {

    public Optional<SensorValue> findById(Integer id);

    // Get the newest record by sensor id in database
    public Optional<SensorValue> findTopBySensorIdOrderByIdDesc(Integer sensorId);

    public List<SensorValue> findAll();

    public long countBySensorId(Integer sensorId);
}
