package com.qa.springcars.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.springcars.domain.Car;

@Repository
public interface CarRepo extends JpaRepository<Car,Long>{
								//Car - Entity
								//Long - ID Data Type
	
	//JPQL - Java Persistence Query Language
	@Query(value = "SELECT * FROM CAR WHERE MAKE = ?1", nativeQuery=true)
	List<Car> findByMake(String make);
}
