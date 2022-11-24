package com.example.rpimeasure.sensorvalues;

import com.example.rpimeasure.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorValueService {
    private final SensorValueRepository sensorValueRepository;

    public SensorValueService(SensorValueRepository sensorValueRepository) {
        this.sensorValueRepository = sensorValueRepository;
    }

    public SensorValue getLatestSensorValueById(Integer sensorId) {
        return sensorValueRepository.findTopBySensorIdOrderByIdDesc(sensorId)
                .orElseThrow(() -> new ResourceNotFoundException("No value found for sensor id: " + sensorId));
    }

    public List<SensorValue> getLatest100SensorValuesById(Integer sensorId) {
        return sensorValueRepository.findTop100BySensorIdOrderByIdDesc(sensorId)
                .orElseThrow(() -> new ResourceNotFoundException("No value found for sensor id: " + sensorId));
    }

    // Get the highest value of a sensor
    public SensorValue getMaxValueOfSensor(Integer sensorId) {
        return sensorValueRepository.findTopBySensorIdOrderByValueDesc(sensorId)
                .orElseThrow(() -> new ResourceNotFoundException("No maximum value found for sensor id: " + sensorId));
    }

    // Get the lowest value of a sensor
    public SensorValue getMinValueOfSensor(Integer sensorId) {
        return sensorValueRepository.findTopBySensorIdOrderByValueAsc(sensorId)
                .orElseThrow(() -> new ResourceNotFoundException("No minimum value found for sensor id: " + sensorId));
    }

    public Long getSensorValueCountById(Integer sensorId) {
        return sensorValueRepository.countBySensorId(sensorId);
    }
}