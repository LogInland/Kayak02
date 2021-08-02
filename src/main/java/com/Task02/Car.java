package com.Task02;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {
	private @Id @GeneratedValue Long id;
	private String name;
	private String type;
	private Double price;

	Car() {}

	Car(String name, String type, Double price) {
		this.name = name;
		this.type = type;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public Double getPrice() {
		return price;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
		return true;
		if (!(obj instanceof Car))
		return false;
		Car car = (Car) obj;
		return Objects.equals(this.id, car.id)
		&& Objects.equals(this.name, car.name)
		&& Objects.equals(this.type, car.type)
		&& Objects.equals(this.price, car.price);
	}

	@Override
	public String toString() {
		return "Car{" + "id=" + this.id
		+ ", name='" + this.name
		+ '\'' + ", type='" + this.type
		+ '\'' + ", price='" + this.price + '\'' + '}';
	}
}
