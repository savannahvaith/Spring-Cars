package com.qa.springcars.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.springcars.domain.Car;
import com.qa.springcars.repo.CarRepo;

@SpringBootTest
public class CarServiceUnitTest {
	
	@MockBean
	private CarRepo repo; 
	
	@Autowired
	private CarService service; 
	
	
	@Test
	void testCreateUnit() {
		// GIVEN 
		
		Car toyota = new Car("Toyota","Corola",2015,4);
		Car toyotaWithId = new Car(1L,"Toyota","Corola",2015,4);
		
		// WHEN 
		
		Mockito.when(this.repo.save(toyota)).thenReturn(toyotaWithId);
		
		// THEN
		
		assertThat(this.service.createVehicle(toyota)).isEqualTo(toyotaWithId);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(toyota);
	}

}
