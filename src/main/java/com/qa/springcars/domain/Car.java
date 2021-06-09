package com.qa.springcars.domain;

public class Car {

	private String make;
	private String model;
	private int year;
	private int doors;

	// Default Constructor - Constructor with NO arguments
	public Car() {
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
