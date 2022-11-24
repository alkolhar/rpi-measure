package com.example.rpimeasure.sensors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sensors")
public class SensorsController {
    private final SensorService sensorService;

    @Autowired
    public SensorsController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping("/add")
    public ResponseEntity<Sensors> addSensor(@RequestBody Sensors sensor) {
        return new ResponseEntity<>(sensorService.addNewSensor(sensor), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Sensors>> getSensors() {
        return new ResponseEntity<>(sensorService.getSensors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sensors> findSensorById(@PathVariable Integer id) {
        return new ResponseEntity<>(sensorService.findSensorsById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteSensorById(@PathVariable Integer id) {
        return new ResponseEntity<>(sensorService.deleteSensor(id), HttpStatus.ACCEPTED);
    }
}
