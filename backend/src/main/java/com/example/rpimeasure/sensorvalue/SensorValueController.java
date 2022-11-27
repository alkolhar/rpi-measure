package com.example.rpimeasure.sensorvalue;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sensors")
public class SensorValueController {
    private final SensorValueService sensorValueService;

    public SensorValueController(SensorValueService sensorValueService) {
        this.sensorValueService = sensorValueService;
    }

    /**
     * Mapping for getting the actual value of a sensor
     *
     * @param sensorId ID of the sensor in the database
     * @return ResponseEntity with the SensorValue object and HTTP status
     */
    @GetMapping("/{sensorId}/actual")
    public ResponseEntity<SensorValue> getLatestSensorValueById(@PathVariable Integer sensorId) {
        return new ResponseEntity<>(sensorValueService.getLatestSensorValueById(sensorId), HttpStatus.OK);
    }

    @GetMapping("/{sensorId}/last")
    public ResponseEntity<List<Double>> getLatestSensorValuesById(@PathVariable Integer sensorId) {
        return new ResponseEntity<>(sensorValueService.getLatestSensorValuesById(sensorId), HttpStatus.OK);
    }

    @GetMapping("/{sensorId}/count")
    public ResponseEntity<Long> getValueCount(@PathVariable Integer sensorId) {
        return new ResponseEntity<>(sensorValueService.getSensorValueCountById(sensorId), HttpStatus.OK);
    }

    @GetMapping("/{sensorId}/max")
    public ResponseEntity<SensorValue> getMaxValueOfSensor(@PathVariable Integer sensorId) {
        return new ResponseEntity<>(sensorValueService.getMaxValueOfSensor(sensorId), HttpStatus.OK);
    }

    @GetMapping("/{sensorId}/min")
    public ResponseEntity<SensorValue> getMinValueOfSensor(@PathVariable Integer sensorId) {
        return new ResponseEntity<>(sensorValueService.getMinValueOfSensor(sensorId), HttpStatus.OK);
    }

    @GetMapping("/{sensorId}/average")
    public ResponseEntity<Double> getAverageValueOfSensor(@PathVariable Integer sensorId) {
        return new ResponseEntity<>(sensorValueService.getAverageValueOfSensorById(sensorId), HttpStatus.OK);
    }
}
