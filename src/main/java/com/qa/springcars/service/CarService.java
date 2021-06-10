package com.qa.springcars.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.springcars.domain.Car;
import com.qa.springcars.repo.CarRepo;

@Service
public class CarService {
	
	private CarRepo repo; 
	
	public CarService(CarRepo repo) {
		this.repo = repo; 
	}
	
	// CRUD
	
	// CREATE
	public Car createVehicle(Car c) {
		return this.repo.save(c);
		// insert into Car values (c.getMake(), c.getModel(), c.getYear(), c.getDoors()); 
	}

	// READ
	public List<Car> getAllVehicles(){
		return this.repo.findAll(); 
	}
	
	// READ ONE
	public Car getVehicle(Long id) {
		Optional<Car> c = this.repo.findById(id);
		return c.get(); 
		
//		Optional<Car> c = this.repo.findById(id);
//		if(c != null) {
//			return c;
//		}else {
//			return null;
//		}
	}
	
	
	// DELETE
	public boolean removeVehicle(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
	
	// UPDATE
	public Car updateVehicle(Long id, Car newCar) {
		Car existing = this.getVehicle(id);
		existing.setMake(newCar.getMake());
		existing.setModel(newCar.getModel());
		existing.setYear(newCar.getYear());
		existing.setDoors(newCar.getDoors());
		
		Car updated = this.repo.save(existing); // save it back to overwrite original
		
		return updated; 
	}
	
	public List<Car> getByMake(String make) {
		return this.repo.findByMake(make);
	}

}
