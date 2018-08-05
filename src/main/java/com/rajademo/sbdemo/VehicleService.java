package com.rajademo.sbdemo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	public Optional<Vehicle> retreiveByVin(String vin) {
		return vehicleRepository.findAllByvin(vin);
	}

	public String delete(String vin) {
		return vehicleRepository.deleteByvin(vin);		
	}

	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	public Vehicle update(Vehicle vehicle) {
		Optional<Vehicle> vInfofromDB = vehicleRepository.findAllByvin(vehicle.getVin());
		Vehicle updatedInfo= vInfofromDB.get();
		updatedInfo.setColor(vehicle.getColor());
		updatedInfo.setPrice(vehicle.getPrice());
		return vehicleRepository.save(updatedInfo);
	}
	
}
