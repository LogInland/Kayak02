package com.Task02;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface CarRepository extends JpaRepository<Car, Long> {
	
	List<Car> findByTypeIn(List<String> type);
}
