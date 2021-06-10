package com.qa.springcars.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springcars.domain.Car;
import com.qa.springcars.service.CarServiceList;

@RestController // Allow eternal access to our application via HTTPRequests
@RequestMapping("/car")
public class CarController {
	
	private CarServiceList service; 
	
	@Autowired
	public CarController(CarServiceList service) {
		this.service = service; 
	}
	
	// CREATE
	
	@PostMapping("/create")
	public ResponseEntity<Car> createVehicle(@RequestBody Car car){
		return new ResponseEntity<Car>(this.service.createVehicle(car), HttpStatus.CREATED);
	}
	
	// READ
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Car>> getAllVehicles(){
		//return new ResponseEntity<List<Car>>(this.vehicles,HttpStatus.OK); 
		// builder pattern 
		return ResponseEntity.ok(this.service.getAllVehicles());
		
	}
	
	// READ ONE
	
	@GetMapping("/getOne/{index}")
	public ResponseEntity<Car> getVehicle(@PathVariable int index) {
		return ResponseEntity.ok(this.service.getVehicle(index));
	}
	
	
	// DELETE ONE
	
	@DeleteMapping("/remove/{index}")
	public ResponseEntity removeVehicle(@PathVariable int index) {
		return this.service.removeVehicle(index) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// PUT - replace the whole thing
	@PutMapping("/replace/{index}")
	public ResponseEntity<Car> updateVehicle(@PathVariable int index, @RequestBody Car newCar){
		this.service.updateVehicle(index, newCar);
		return new ResponseEntity<Car>(newCar, HttpStatus.ACCEPTED);
	}
	
	// PATCH - Update a single bit of the data
	@PatchMapping("/update/{index}")
	public ResponseEntity<Car> changeAttribute(@PathParam("make") String make, @PathParam("model") String model, @PathVariable int index){
		
//		Car updatedVehicle = this.vehicles.get(index);		
//		updatedVehicle.setMake(make);
//		updatedVehicle.setModel(model);
		return null; 
//		return new ResponseEntity<Car>(, HttpStatus.ACCEPTED);
	}
	

}


