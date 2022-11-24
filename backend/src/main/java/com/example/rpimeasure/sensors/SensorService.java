package com.example.rpimeasure.sensors;

import com.example.rpimeasure.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {
    private final SensorsRepository sensorsRepository;

    @Autowired
    public SensorService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    public Sensors addNewSensor(Sensors sensor) {
        return sensorsRepository.save(sensor);
    }

    public List<Sensors> getSensors() {
        return sensorsRepository.findAllByOrderByIdAsc();
    }

    public Sensors findSensorsById(Integer id) {
        return sensorsRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sensor with id: " + id + " does not exist!"));
    }

    public boolean deleteSensor(Integer id) {
        boolean sensorExists = sensorsRepository.existsById(id);
        if (sensorExists) {
            sensorsRepository.deleteById(id);
        }
        return sensorExists;
    }
}
