package com.example.rpimeasure.sensorvalues;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SensorValueRepository extends CrudRepository<SensorValue, Integer> {

    public Optional<SensorValue> findById(Integer id);

    public Iterable<SensorValue> findAll();

    public long count();
}
