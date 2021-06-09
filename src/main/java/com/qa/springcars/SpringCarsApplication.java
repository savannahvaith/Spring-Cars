package com.qa.springcars;

import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCarsApplication {

	public static void main(String[] args) {
		ApplicationContext beanBag = SpringApplication.run(SpringCarsApplication.class, args);
		
		beanBag.containsBean("getCurrent");

	}

	// By default Beans have a SINGLETON instance = only one instance that is
	// continuously changed
	// BEAN - Managed object By Spring
	@Bean
	public LocalTime getCurrent() {
		return LocalTime.now();
	}

}
