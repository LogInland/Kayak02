package com.Task02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jdk.internal.org.jline.utils.Log;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class Task02ApplicationTests {

	@Autowired
	private CarRepository carRepository;

	private static final Logger log =
	LoggerFactory.getLogger(Task02ApplicationTests.class);

	@Test
	@Transactional
	public void testFindByTypeIn() {

		log.info("... testFinfByTypeIn ...");

		List<String> carTypes = new ArrayList<String>();
		carTypes.add("SMALL");
		
		List<Car> cars = carRepository.findByTypeIn(carTypes);
		assertNotNull(cars);
		assertFalse(cars.isEmpty());
		log.info("findByTypeIn result: " + Arrays.toString(cars.toArray()));
	}
}
