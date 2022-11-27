package com.example.rpimeasure;

import com.example.rpimeasure.sensors.SensorsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	private SensorsController sensorsController;

	@Test
	void contextLoads() {
		// Simple Sanity Check
		assertThat(sensorsController).isNotNull();
	}

}
