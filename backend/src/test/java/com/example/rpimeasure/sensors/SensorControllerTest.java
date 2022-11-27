package com.example.rpimeasure.sensors;

import com.example.rpimeasure.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SensorsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private SensorsService sensorsService;

    @Test
    public void shouldFindPressureBedroomSensor() throws Exception {
        this.mockMvc.perform(get("/api/v1/sensors/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("pressBedSensor")));
    }

    @Test
    public void shouldReturnResourceNotFoundException() throws Exception {
        this.mockMvc.perform(get("/api/v1/sensors/999999"))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ResourceNotFoundException));
    }

    @Test
    public void shouldCreateAndDeleteSensor() {
        String testName = "name";
        String testDescription = "description";
        String testUnit = "unit";
        String testPhotoUrl = "photoUrl";

        Sensors testSensor = sensorsService.addNewSensor(
                new Sensors(
                        testName,
                        testDescription,
                        testUnit,
                        testPhotoUrl
                )
        );

        // check if sensor can be found
        Sensors sensorsById = sensorsService.findSensorsById(testSensor.getId());
        assertNotNull(sensorsById);
        // check if values have been saved correctly
        assertEquals(sensorsById.getId(), testSensor.getId());
        assertEquals(sensorsById.getName(), testName);
        assertEquals(sensorsById.getDescription(), testDescription);
        assertEquals(sensorsById.getUnit(), testUnit);
        assertEquals(sensorsById.getPhotoUrl(), testPhotoUrl);

        // check that sensor is removed
        assertTrue(sensorsService.deleteSensor(testSensor.getId()));
    }
}
