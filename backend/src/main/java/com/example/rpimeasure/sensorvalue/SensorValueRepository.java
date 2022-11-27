package com.example.rpimeasure.sensorvalue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SensorValueRepository extends JpaRepository<SensorValue, Integer> {

    // Get the newest record by sensor id in database
    Optional<SensorValue> findTopBySensorIdOrderByIdDesc(Integer sensorId);

    // Get all values from a sensor ordered by timestamp (the newest first)
    @Query("select s.value from SensorValue s where s.sensorId = ?1 order by s.timestamp DESC")
    Optional<List<Double>> findValuesBySensorIdOrderByTimestampDesc(Integer sensorId);

    long countBySensorId(Integer sensorId);

    Optional<SensorValue> findTopBySensorIdOrderByValueAsc(Integer sensorId);

    Optional<SensorValue> findTopBySensorIdOrderByValueDesc(Integer sensorId);
}
