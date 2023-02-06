package com.example.vehicle.service;

import java.util.List;

import com.example.vehicle.model.Vehicle;

public interface VehicleService {
	//To save Vehicle 
	Vehicle saveVehicle(Vehicle vehicle);
		
	//To get all the details
	List<Vehicle> getVehicle();
	
	//To get based on id
	Vehicle getById(int id);
	
	//To get based on Color
	List<Vehicle> getByColor();
	
	//Sorted by Price
	List<Vehicle> getByPriceSorted(int pageNo, int noOfRecords);
	
	//Price more than 10,00,000
	List<Vehicle> morethan10L();
	
	//To Update based on ID
	Vehicle updateVehicle(Vehicle vehicle, int id);
	
	//To Delete based on ID
	String DeleteVehicle(int id);
}
