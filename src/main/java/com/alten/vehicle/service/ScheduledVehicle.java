package com.alten.vehicle.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alten.vehicle.client.VehicleHealthRecorder;
import com.alten.vehicle.config.Properties;
import com.alten.vehicle.model.Vehicle;

@Component
@Scope("prototype")
@EnableFeignClients
@EnableScheduling
public class ScheduledVehicle {

	@Autowired
	private VehicleHealthRecorder vehicleCustomerAggregator;

	@Autowired
	Properties properties;

	private Vehicle vehicle;

	public ScheduledVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	// TODO: replace fixedDelay by fixedDelayString = ${properties.pingDelay}
	@Scheduled(fixedDelay = 6000, initialDelay = 0)
	public void sendStatus() {
		vehicleCustomerAggregator.ping(vehicle.getId(), Boolean.valueOf(new Random().nextBoolean()).toString());
	}

}
