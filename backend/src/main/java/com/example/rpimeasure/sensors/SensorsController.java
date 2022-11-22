package com.example.rpimeasure.sensors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/sensors")
public class SensorsController {
    private final SensorService sensorService;

    public SensorsController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping("/add")
    public void addSensor(@RequestBody Sensors sensor) {
        sensorService.addNewSensor(sensor);
    }

    @GetMapping()
    public List<Sensors> getSensors() {
        return sensorService.getSensors();
    }

    @GetMapping("/{id}")
    public Sensors findSensorById(@PathVariable Integer id) {
        return sensorService.findSensorsById(id);
    }
}
