package com.qa.springcars.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Marks as Table!
public class Car {

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENT
	private Long id;
	
	private String make;
	
	private String model;
	
	private int year;
	
	private int doors;

	// Default Constructor - Constructor with NO arguments
	public Car() {
		// REQUIRED!
	}

	// Constructor
	public Car(String make, String model, int year, int doors) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.doors = doors;
	}

	// getters and setters - interact with attributes

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

}
