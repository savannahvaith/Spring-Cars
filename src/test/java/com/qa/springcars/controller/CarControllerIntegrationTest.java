package com.qa.springcars.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.springcars.domain.Car;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CarControllerIntegrationTest {

	@Autowired
	private MockMvc mock; // to mock our controller as well as any relevant mappers
	
	@Autowired
	private ObjectMapper mapper; // convert our requests to JSON Format
	
	/*
	 * {
	 * 	"make":"Toyota",
	 * 	"model":"Corola",
	 * 	"year":2015,
	 *  "doors":4
	 * }
	 */
	
	@Test
	void testCreate() throws Exception {
		
//		// Creating our car
//		Car vehicle1 = new Car("Toyota","Corola",2015,4);
//		
//		// convert it to a JSON string
//		String vehicle1AsJSON = this.mapper.writeValueAsString(vehicle1);
//		
//		// Build our mock REQUEST
//		
//		RequestBuilder mockRequest = 
//				post("/car/create")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(vehicle1AsJSON);
//		
//		// Create our "saved" car
//		Car savedVechicle = new Car(1L,"Toyota","Corola",2015,4);
//		
//		// Convert "saved" car into JSON
//		String savedVehicleAsJSON = this.mapper.writeValueAsString(savedVechicle);
//		
//		// Check status is 201 - CREATED
//		ResultMatcher matchStatus = status().isCreated();
//		
//		// Check the response body - correct "saved" car
//		ResultMatcher matchBody = content().json(savedVehicleAsJSON);
//		
//		// build the request!
//		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
		
		
		// for demo purposes:
		
		this.mock.perform(
				post("/car/create")
					.contentType(MediaType.APPLICATION_JSON)
					.content(this.mapper.writeValueAsString(new Car("Toyota","Corola",2015,4))))
				.andExpect(status().isCreated())
				.andExpect(content().json(this.mapper.writeValueAsString(new Car(1L,"Toyota","Corola",2015,4))));
		
	}
	
	
}
