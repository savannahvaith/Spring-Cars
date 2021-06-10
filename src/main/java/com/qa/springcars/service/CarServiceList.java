package com.qa.springcars.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springcars.domain.Car;

@Service // main business logic of our application lives!
public class CarServiceList {

	private List<Car> vehicles; // <-- dependency

	// Constructor
	public CarServiceList(List<Car> vehicles) {
		this.vehicles = vehicles;
	}

	// CREATE
	public Car createVehicle(Car car) {
		this.vehicles.add(car);
		// Grab the last thing that was added to the list
		Car added = this.vehicles.get(this.vehicles.size() - 1);
		return added;
	}

	// READ
	public List<Car> getAllVehicles() {
		return this.vehicles;

	}

	// READ ONE
	public Car getVehicle(int index) {
		return this.vehicles.get(index);
	}

	// DELETE 
	public boolean removeVehicle(int index) {
		 this.vehicles.remove(index);
		 return true;
	}

	// PUT - replace the whole thing
	public Car updateVehicle(int index, Car newCar) {
		this.vehicles.set(index, newCar);
		return newCar;
	}

}
