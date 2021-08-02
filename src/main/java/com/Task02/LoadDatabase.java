package com.Task02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
	
	private static final Logger log =
	LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(CarRepository repository) {

		return args -> {
			log.info("Preloading " + repository.save(new Car("Nissan Versa",
			"SMALL", 217.0)));
			log.info("Preloading " + repository.save(new Car("Ford Focus",
			"SMALL", 215.0)));

			log.info("Preloading " + repository.save(new Car("Hyundai Elantra",
			"MEDIUM", 217.0)));
			log.info("Preloading " + repository.save(new Car("Toyota Corolla",
			"MEDIUM", 226.0)));

			log.info("Preloading " + repository.save(new Car("Chervrolet Malibu",
			"LARGE", 244.0)));
			log.info("Preloading " + repository.save(new Car("Ford Fusion",
			"LARGE", 241.0)));

			log.info("Preloading " + repository.save(new Car("Nissan Rogue",
			"SUV", 294.0)));
			log.info("Preloading " + repository.save(new Car("Jeep Cherokee",
			"SUV", 320.0)));

			log.info("Preloading " + repository.save(new Car("Chrysler Pacifica",
			"VAN", 420.0)));
			log.info("Preloading " + repository.save(new Car("Ford Transit",
			"VAN", 453.0)));

			log.info("Preloading " + repository.save(new Car("RAM Pickup",
			"PICKUPTRUCK", 928.0)));
			log.info("Preloading " + repository.save(new Car("Ford F-150",
			"PICKUPTRUCK", 1245.0)));

			log.info("Preloading " + repository.save(new Car("Chrysler 300",
			"LUXURY", 376.0)));
			log.info("Preloading " + repository.save(new Car("BMW 3 Series",
			"LUXURY", 618.0)));

			log.info("Preloading " + repository.save(new Car("Ford Mustang Convertible",
			"CONVERTIBLE", 490.0)));
			log.info("Preloading " + repository.save(new Car("Convertible car",
			"CONVERTIBLE", 510.0)));

			log.info("Preloading " + repository.save(new Car("Chevrolet Exprexx	Cargo",
			"Commercial", 657.0)));
		};
	}
}
