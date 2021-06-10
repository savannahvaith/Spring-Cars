package com.qa.springcars.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springcars.domain.Car;

@Repository
public interface CarRepo extends JpaRepository<Car,Long>{
								//Car - Entity
								//Long - ID Data Type
}
