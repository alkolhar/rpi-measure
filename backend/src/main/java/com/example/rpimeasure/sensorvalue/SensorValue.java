package com.example.rpimeasure.sensorvalue;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_values")
public class SensorValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer sensorId;
    private LocalDateTime timestamp;
    private Double value;

    public Integer getId() {
        return id;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensor_id) {
        this.sensorId = sensor_id;
    }

    public LocalDateTime getTimestamp() { return timestamp; }

    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
