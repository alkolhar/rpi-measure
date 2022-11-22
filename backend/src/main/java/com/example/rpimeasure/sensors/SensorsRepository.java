package com.example.rpimeasure.sensors;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SensorsRepository extends CrudRepository<Sensors, Integer> {

    List<Sensors> findAllByOrderByIdAsc();
}
