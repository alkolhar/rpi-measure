package com.example.rpimeasure.sensorvalues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/sensors")
public class SensorValueController {
    @Autowired
    private SensorValueRepository sensorValueRepository;

    @GetMapping("{sensorId}/actual")
    public Optional<SensorValue> getLatestSensorValueById(@PathVariable Integer sensorId) {
        return sensorValueRepository.findTopBySensorIdOrderByIdDesc(sensorId);
    }

    @GetMapping("{sensorId}/count")
    public Long getValueCount(@PathVariable Integer sensorId) {
        return sensorValueRepository.countBySensorId(sensorId);
    }
}
