package com.example.rpimeasure.sensors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sensors")
public class SensorsController {
    @Autowired
    private SensorsRepository sensorsRepository;

    @PostMapping("/add")
    public String addSensor(@RequestParam String name, @RequestParam String description, @RequestParam String unit, @RequestParam String photoUrl) {
        Sensors sensors = new Sensors();
        sensors.setName(name);
        sensors.setDescription(description);
        sensors.setUnit(unit);
        sensors.setPhotoUrl(photoUrl);
        sensorsRepository.save(sensors);
        return "Added new sensor to repo!";
    }

    @GetMapping("/list")
    public Iterable<Sensors> getSensors() { return sensorsRepository.findAll(); }

    @GetMapping("/{id}")
    public Sensors findSensorById(@PathVariable Integer id) {
        return sensorsRepository.findSensorsById(id);
    }
}
