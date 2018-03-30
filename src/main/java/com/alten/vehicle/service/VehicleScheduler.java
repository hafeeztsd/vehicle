package com.alten.vehicle.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.alten.vehicle.model.Vehicle;

@Service
public class VehicleScheduler  implements ApplicationContextAware {

	private ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	public void schedule(Vehicle vehicle) {
		context.getBean(ScheduledVehicle.class, vehicle);
	}
}
