package com.example.rpimeasure.sensorvalues;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SensorValueRepository extends JpaRepository<SensorValue, Integer> {

    // Get the newest record by sensor id in database
    Optional<SensorValue> findTopBySensorIdOrderByIdDesc(Integer sensorId);

    // Get the last 100 records by sensor id in database
    Optional<List<SensorValue>> findTop100BySensorIdOrderByIdDesc(Integer sensorId);

    long countBySensorId(Integer sensorId);


    Optional<SensorValue> findTopBySensorIdOrderByValueAsc(Integer sensorId);

    Optional<SensorValue> findTopBySensorIdOrderByValueDesc(Integer sensorId);
}
