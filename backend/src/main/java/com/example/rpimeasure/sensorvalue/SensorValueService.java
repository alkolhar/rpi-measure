package com.example.rpimeasure.sensorvalue;

import com.example.rpimeasure.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorValueService {
    private final SensorValueRepository sensorValueRepository;

    public SensorValueService(SensorValueRepository sensorValueRepository) {
        this.sensorValueRepository = sensorValueRepository;
    }

    /**
     * Get the newest record by sensor id in database
     *
     * @param sensorId ID of the sensor in the database
     * @return SensorValue object
     */
    public SensorValue getLatestSensorValueById(Integer sensorId) {
        return sensorValueRepository.findTopBySensorIdOrderByIdDesc(sensorId)
                .orElseThrow(() -> new ResourceNotFoundException("No value found for sensor id: " + sensorId));
    }

    /**
     * Get the values of the sensor by id, ordered by timestamp descending
     *
     * @param sensorId ID of the sensor in the database
     * @return List of measured sensor values
     */
    public List<Double> getLatestSensorValuesById(Integer sensorId) {
        return sensorValueRepository.findValuesBySensorIdOrderByTimestampDesc(sensorId)
                .orElseThrow(() -> new ResourceNotFoundException("No value found for sensor id: " + sensorId));
    }

    /**
     * Get the highest value of the sensor by id
     *
     * @param sensorId ID of the sensor in the database
     * @return SensorValue object with the highest value
     */
    public SensorValue getMaxValueOfSensor(Integer sensorId) {
        return sensorValueRepository.findTopBySensorIdOrderByValueDesc(sensorId)
                .orElseThrow(() -> new ResourceNotFoundException("No maximum value found for sensor id: " + sensorId));
    }

    /**
     * Get the lowest value of the sensor by id
     *
     * @param sensorId ID of the sensor in the database
     * @return SensorValue object with the lowest value
     */
    public SensorValue getMinValueOfSensor(Integer sensorId) {
        return sensorValueRepository.findTopBySensorIdOrderByValueAsc(sensorId)
                .orElseThrow(() -> new ResourceNotFoundException("No minimum value found for sensor id: " + sensorId));
    }

    /**
     * Get the average value of the sensor by id
     *
     * @param sensorId ID of the sensor in the database
     * @return Average value of the sensor
     */
    public Double getAverageValueOfSensorById(Integer sensorId) {
        return sensorValueRepository.findById(sensorId).stream().
                mapToDouble(SensorValue::getValue)
                .average()
                .orElseThrow(() -> new ResourceNotFoundException("No average value found for sensor id: " + sensorId));
    }

    /**
     * Get the count of values of the sensor by id
     *
     * @param sensorId ID of the sensor in the database
     * @return Count of values of the sensor
     */
    public Long getSensorValueCountById(Integer sensorId) {
        return sensorValueRepository.countBySensorId(sensorId);
    }
}

