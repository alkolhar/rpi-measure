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

    @GetMapping("{id}/actual")
    public Optional<SensorValue> getSensorValueById(@PathVariable Integer id) {
        return sensorValueRepository.findById(id);
    }
}
