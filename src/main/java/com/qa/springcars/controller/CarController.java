package com.qa.springcars.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Allow eternal access to our application via HTTPRequests
public class CarController {
	
	@GetMapping("/hello") // @TypeOfRequest("location")
	public String sayHi() {
		return "Hello, World";
	}

}


