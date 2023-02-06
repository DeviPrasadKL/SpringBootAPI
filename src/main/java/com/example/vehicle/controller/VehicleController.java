package com.example.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehicle.model.Vehicle;
import com.example.vehicle.service.VehicleService;
@CrossOrigin
@RestController
public class VehicleController {
	
	@Autowired
	VehicleService service;
	
	//Adding a VehicleS
	@PostMapping("AddVehicle")
	public ResponseEntity<Vehicle> saveVehicle(@RequestBody Vehicle vehicle){
		return new ResponseEntity<Vehicle>(service.saveVehicle(vehicle),HttpStatus.CREATED);
	}
	
	//Getting all the data
	@GetMapping("Vehicles")
	public List<Vehicle> getVehicle(){
		return service.getVehicle();
	}
	
	//Getting based on id
	@GetMapping("Vehicle/{id}")
	public ResponseEntity<Vehicle> getById(@PathVariable("id") int id){
		return new ResponseEntity<Vehicle>(service.getById(id),HttpStatus.OK);
	}
	
	//To get based on Color
	@GetMapping("Color/Silver")
	public List<Vehicle> getByColor(){
		return service.getByColor();
	}
	
	//Sorted by Price
	@GetMapping("Price/Sorted/{pageNo}/{noOfRecords}")
	public List<Vehicle> getByPriceSorted(@PathVariable int pageNo, @PathVariable int noOfRecords){
		return service.getByPriceSorted(pageNo, noOfRecords);
	}
	
	//Price more than 10,00,000
	@GetMapping("Price/MoreThan10L")
	public List<Vehicle> morethan10L(){
		return service.morethan10L();
	}
	
	//To Update based on ID
	@PutMapping("Update/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle ,@PathVariable("id") int id){
		return new ResponseEntity<Vehicle>(service.updateVehicle(vehicle, id),HttpStatus.OK);
	}
	
	//To Delete based on ID
	@DeleteMapping("Delete/{id}")
	public String deleteVehicle(@PathVariable("id") int id) {
		return service.DeleteVehicle(id);
	}
}










