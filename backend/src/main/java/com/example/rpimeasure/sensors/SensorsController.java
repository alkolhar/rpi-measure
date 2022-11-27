package com.example.rpimeasure.sensors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sensors")
public class SensorsController {
    private final SensorsService sensorsService;

    @Autowired
    public SensorsController(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @PostMapping("/add")
    public ResponseEntity<Sensors> addSensor(@RequestBody Sensors sensor) {
        return new ResponseEntity<>(sensorsService.addNewSensor(sensor), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Sensors>> getSensors() {
        return new ResponseEntity<>(sensorsService.getSensors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sensors> findSensorById(@PathVariable Integer id) {
        return new ResponseEntity<>(sensorsService.findSensorsById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sensors> updateSensor(@PathVariable Integer id,
                                                @RequestParam(required = false) String name,
                                                @RequestParam(required = false) String description,
                                                @RequestParam(required = false) String unit,
                                                @RequestParam(required = false) String photoUrl) {
        return new ResponseEntity<>(sensorsService.updateSensor(id, name, description, unit, photoUrl), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteSensorById(@PathVariable Integer id) {
        return new ResponseEntity<>(sensorsService.deleteSensor(id), HttpStatus.ACCEPTED);
    }
}

