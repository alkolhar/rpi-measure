package com.example.rpimeasure.sensors;

import com.example.rpimeasure.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorsService {
    private final SensorsRepository sensorsRepository;

    @Autowired
    public SensorsService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    public Sensors addNewSensor(Sensors sensor) {
        return sensorsRepository.save(sensor);
    }

    public List<Sensors> getSensors() {
        return sensorsRepository.findAllByOrderByIdAsc();
    }

    public Sensors findSensorsById(Integer id) {
        return sensorsRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sensor with id: " + id + " does not exist!"));
    }

    public boolean deleteSensor(Integer id) {
        boolean sensorExists = sensorsRepository.existsById(id);
        if (sensorExists) {
            sensorsRepository.deleteById(id);
        }
        return sensorExists;
    }

    public Sensors updateSensor(Integer id, String name, String description, String unit, String photoUrl) {
        Sensors sensorToUpdate = sensorsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sensor with id: " + id + " does not exist!"));

        if (name != null && name.length() > 0 && !sensorToUpdate.getName().equals(name)) {
            sensorToUpdate.setName(name);
        }
        if (description != null && description.length() > 0 && !sensorToUpdate.getDescription().equals(description)) {
            sensorToUpdate.setDescription(description);
        }
        if (unit != null && unit.length() > 0 && !sensorToUpdate.getUnit().equals(unit)) {
            sensorToUpdate.setUnit(unit);
        }
        if (photoUrl != null && photoUrl.length() > 0 && !sensorToUpdate.getPhotoUrl().equals(photoUrl)) {
            sensorToUpdate.setPhotoUrl(photoUrl);
        }
        return sensorToUpdate;
    }
}
