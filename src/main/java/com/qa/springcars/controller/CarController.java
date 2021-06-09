package com.qa.springcars.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springcars.domain.Car;

@RestController // Allow eternal access to our application via HTTPRequests
public class CarController {
	
	@GetMapping("/hello") // @TypeOfRequest("location")
	public String sayHi() {
		return "Hello, World";
	}
	
	private List<Car> vehicles = new ArrayList<>(); 
	
	
	// List - Create a new car - Add a car to a list
	// Read a car from a list
	// Update a car 
	// Delete a car
	
	// CREATE
	
	@PostMapping("/create")
	public ResponseEntity<Car> createVehicle(@RequestBody Car car){
		this.vehicles.add(car);
		// Grab the last thing that was added to the list
		Car added = this.vehicles.get(this.vehicles.size()-1);
		return new ResponseEntity<Car>(added, HttpStatus.CREATED);
	}
	
	// READ
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Car>> getAllVehicles(){
		//return new ResponseEntity<List<Car>>(this.vehicles,HttpStatus.OK); 
		// builder pattern 
		return ResponseEntity.ok(this.vehicles);
		
	}
	
	// READ ONE
	
	@GetMapping("/getOne/{index}")
	public ResponseEntity<Car> getVehicle(@PathVariable int index) {
		return ResponseEntity.ok(this.vehicles.get(index));
	}
	
	
	// DELETE ONE
	
	@DeleteMapping("/remove/{index}")
	public ResponseEntity removeVehicle(@PathVariable int index) {
		return this.vehicles.remove(index) != null ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// PUT - replace the whole thing
	@PutMapping("/replace/{index}")
	public ResponseEntity<Car> updateVehicle(@PathVariable int index, @RequestBody Car newCar){
		this.vehicles.set(index, newCar);
		return new ResponseEntity<Car>(newCar, HttpStatus.ACCEPTED);
	}
	
	// PATCH - Update a single bit of the data
	@PatchMapping("/update/{index}")
	public ResponseEntity<Car> changeAttribute(@PathParam("make") String make, @PathParam("model") String model, @PathVariable int index){
		
		Car updatedVehicle = this.vehicles.get(index);		
		updatedVehicle.setMake(make);
		updatedVehicle.setModel(model);
		
		return new ResponseEntity<Car>(updatedVehicle, HttpStatus.ACCEPTED);
	}
	

}


