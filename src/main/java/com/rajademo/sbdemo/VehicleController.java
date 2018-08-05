package com.rajademo.sbdemo;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	private VehicleService vehicleService;
	
	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}
	
	@GetMapping(value="/msg" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<String>> greet() {
		return ResponseEntity.ok(new ResponseVO<>("Hello Demo!!!"));
	}
	
	@GetMapping(value="/all" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Iterable<Vehicle>>> findAll() {
		return ResponseEntity.ok(new ResponseVO<>(vehicleService.findAll()));
	}

	@GetMapping(value = "/vin/{vin}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Optional<Vehicle>>> retreiveByVin(@PathVariable("vin") String vin) {
		return ResponseEntity.ok(new ResponseVO<>(vehicleService.retreiveByVin(vin)));
	}
	
	@PostMapping(value = "/vin" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Vehicle>> create(@RequestBody Vehicle vehicle) {
		Vehicle savedVehicle= vehicleService.save(vehicle);
		return ResponseEntity.created(URI.create("/" + vehicle.getId())).body(new ResponseVO<>(savedVehicle));
	}

	@PutMapping(value = "/vin" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Vehicle>> update(@RequestBody Vehicle vehicle) {
		Vehicle updatedVehicle= vehicleService.update(vehicle);
		return ResponseEntity.created(URI.create("/" + vehicle.getId())).body(new ResponseVO<>(updatedVehicle));
	}
	
	@DeleteMapping(value = "/vin/{vin}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<String>> delete(@PathVariable("vin") String vin) {
		vehicleService.delete(vin);
		return ResponseEntity.ok(new ResponseVO<>(vin + ":: Deleted Successfully"));
	}


}
