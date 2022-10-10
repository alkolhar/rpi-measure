package com.example.rpimeasure.sensorvalues;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_values")
public class SensorValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer sensor_id;
    private LocalDateTime timestamp;
    private Double value;

    public Integer getId() {
        return id;
    }

    public Integer getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(Integer sensor_id) {
        this.sensor_id = sensor_id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
