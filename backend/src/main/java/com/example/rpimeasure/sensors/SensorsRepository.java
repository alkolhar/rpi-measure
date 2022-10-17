package com.example.rpimeasure.sensors;

import org.springframework.data.repository.CrudRepository;

public interface SensorsRepository extends CrudRepository<Sensors, Integer> {
    Sensors findSensorsById(Integer id);

    Iterable<Sensors> findAllByOrderByIdAsc();
}
