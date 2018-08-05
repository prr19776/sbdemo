package com.rajademo.sbdemo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends  JpaRepository<Vehicle, String>{

	Optional<Vehicle> findAllByvin(String vin);
	String deleteByvin(String vin);
}
