package com.Task02;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@RestController
public class CarController {
	
	private final CarRepository repository;

	CarController(CarRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/cars")
	List<Car> all() {
		return repository.findAll();
	}

	@GetMapping("/cars/{id}")
	Car one(@PathVariable Long id) {

		return repository.findById(id)
			.orElseThrow(() -> new CarNotFoundException(id));
	}

	@GetMapping("/cars/type")
	CollectionModel<EntityModel<Car>> getCarByType(@RequestParam List<String> carType) {

		List<EntityModel<Car>> cars = repository.findByTypeIn(carType).stream()
			.map(car -> EntityModel.of(car,
			linkTo(methodOn(CarController.class).one(car.getId())).withSelfRel(),
			linkTo(methodOn(CarController.class).all()).withRel("cars")))
			.collect(Collectors.toList());

		return CollectionModel.of(cars, linkTo(methodOn(CarController.class)
			.all()).withSelfRel());
	}
}
