package com.example.vehicle.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.vehicle.exception.ResourceNotFoundException;
import com.example.vehicle.model.Vehicle;
import com.example.vehicle.repo.VehicleRepo;
import com.example.vehicle.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	VehicleRepo repo;
	
	//To save Vehicle 
	@Override
	public Vehicle saveVehicle(Vehicle vehicle) {
		repo.save(vehicle);
		return vehicle;
	}

	//To get all the details
	@Override
	public List<Vehicle> getVehicle() {
		List<Vehicle> list = repo.findAll();
		return list;
	}

	//To get based on id
	@Override
	public Vehicle getById(int id) {
		Optional<Vehicle> vehicle = repo.findById(id);
		if(vehicle.isPresent()) {
			return vehicle.get();
		}else {
			throw new ResourceNotFoundException("Vehicle", "ID", id);
		}
	}

	//To get based on Color
	@Override
	public List<Vehicle> getByColor() {
		return repo.getByColor();
	}

	//Sorted by Price
	@Override
	public List<Vehicle> getByPriceSorted(int pageNo, int noOfRecords) {
		Pageable pageable = PageRequest.of(pageNo, noOfRecords, Sort.by("v_color"));
		return repo.getByPriceSorted(pageable);
	}

	//Price more than 10,00,000
	@Override
	public List<Vehicle> morethan10L() {
		return repo.morethan10L();
	}

	//To Update based on ID
	@Override
	public Vehicle updateVehicle(Vehicle vehicle, int id) {
		Vehicle vehicle2 = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "ID", id));
		vehicle2.setvName(vehicle.getvName());
		vehicle2.setvPrice(vehicle.getvPrice());
		vehicle2.setvModel(vehicle.getvModel());
		vehicle2.setvColor(vehicle.getvColor());
		repo.save(vehicle2);
		return vehicle2;
	}

	//To Delete based on ID
	@Override
	public String DeleteVehicle(int id) {
		Vehicle vehicle = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "ID", id));
		repo.delete(vehicle);
		return "Vehicle Deleted";
	}
	
}









