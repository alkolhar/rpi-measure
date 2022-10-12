package com.example.rpimeasure.sensors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SensorsRepositoryTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnBedroomSensorInformation() throws Exception {
        this.mockMvc.perform(get("/sensors/1")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("pressBedSensor"))
                .andExpect(jsonPath("$.description").value("Bedroom Pressure Sensor"))
                .andExpect(jsonPath("$.unit").value("hPa"))
                .andExpect(jsonPath("$.photoUrl").value("a"));
    }
}