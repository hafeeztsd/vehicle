package com.alten.vehicle.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alten.vehicle.model.Vehicle;
import com.alten.vehicle.service.VehicleService;

@RestController
@RequestMapping(path = "/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@RequestMapping(method = RequestMethod.POST)
	public String createVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.create(vehicle);
	}
}
