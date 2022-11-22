package com.example.rpimeasure.sensorvalues;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/sensors")
public class SensorValueController {
    private final SensorValueRepository sensorValueRepository;

    public SensorValueController(SensorValueRepository sensorValueRepository) {
        this.sensorValueRepository = sensorValueRepository;
    }

    @GetMapping("/{sensorId}/actual")
    public Optional<SensorValue> getLatestSensorValueById(@PathVariable Integer sensorId) {
        return sensorValueRepository.findTopBySensorIdOrderByIdDesc(sensorId);
    }

    @GetMapping("/{sensorId}/count")
    public Long getValueCount(@PathVariable Integer sensorId) {
        return sensorValueRepository.countBySensorId(sensorId);
    }

    @GetMapping("/{sensorId}/max")
    public Optional<SensorValue> getMaxValueOfSensor(@PathVariable Integer sensorId) {
        return sensorValueRepository.findById(sensorId);
    }

    @GetMapping("/{sensorId}/min")
    public Long getMinValueOfSensor(@PathVariable Integer sensorId) {
        return sensorValueRepository.countBySensorId(sensorId);
    }

}
