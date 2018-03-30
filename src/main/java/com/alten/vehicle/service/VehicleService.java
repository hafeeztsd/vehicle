package com.alten.vehicle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alten.vehicle.model.Vehicle;
import com.alten.vehicle.repo.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleScheduler vehicleScheduler;

	@Autowired
	private VehicleRepository vehicleRepository;

	public String create(Vehicle vehicle) {
		vehicle = vehicleRepository.save(vehicle);
		vehicleScheduler.schedule(vehicle);
		return vehicle.getId();
	}

}
