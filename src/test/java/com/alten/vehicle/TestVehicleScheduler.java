package com.alten.vehicle;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alten.vehicle.client.VehicleHealthRecorder;
import com.alten.vehicle.model.Vehicle;
import com.alten.vehicle.service.ScheduledVehicle;
import com.alten.vehicle.service.VehicleScheduler;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { VehicleSchedulerTestConfig.class, ScheduledVehicle.class })
public class TestVehicleScheduler {

	@Autowired
	private VehicleScheduler vehicleScheduler;

	@Autowired
	private VehicleHealthRecorder vehicleCustomerAggregator;

	@Test
	public void testSchedule() {
		String vehicleId = "V-342";
		String vehicleRegNo = "V-R-35HJS3";
		Mockito.when(vehicleCustomerAggregator.ping(vehicleId, Boolean.TRUE.toString()))
				.thenReturn(Boolean.TRUE.toString());
		Vehicle vehicle = new Vehicle(vehicleId, vehicleRegNo);
		vehicleScheduler.schedule(vehicle);
		Assert.assertTrue(true);
	}
}
