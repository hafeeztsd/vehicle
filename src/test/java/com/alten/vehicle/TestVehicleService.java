package com.alten.vehicle;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alten.vehicle.model.Vehicle;
import com.alten.vehicle.repo.VehicleRepository;
import com.alten.vehicle.service.VehicleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { VehicleServiceTestConfig.class })
public class TestVehicleService {

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private VehicleRepository vehicleRepository;

	@Test
	public void testCreateVehicle() {
		String vehicleId = "Test_V1";
		String vehicleRegNo = "Test_V1_REGNO_123456";
		Vehicle vehicle = new Vehicle(vehicleId, vehicleRegNo);
		Mockito.when(vehicleRepository.save(vehicle)).thenReturn(vehicle);
		String createdVehicleId = vehicleService.create(vehicle);
		Assert.assertEquals(vehicleId, createdVehicleId);
	}
}
