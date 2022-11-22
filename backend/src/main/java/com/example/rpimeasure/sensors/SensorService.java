package com.example.rpimeasure.sensors;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {
    private final SensorsRepository sensorsRepository;

    public SensorService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    public void addNewSensor(Sensors sensor) {
        sensorsRepository
                .findById(sensor.getId())
                .orElseThrow(() -> new IllegalStateException("Sensor already exists!"));

        sensorsRepository.save(sensor);
    }

    public List<Sensors> getSensors() {
        return sensorsRepository.findAllByOrderByIdAsc();
    }

    public Sensors findSensorsById(Integer id) {
        return sensorsRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("Sensor with id: " + id + " does not exist!"));
    }
}
