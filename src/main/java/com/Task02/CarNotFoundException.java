package com.Task02;

class CarNotFoundException extends RuntimeException{

	CarNotFoundException(Long id) {
		super("Could not find car " + id);
	}
}
