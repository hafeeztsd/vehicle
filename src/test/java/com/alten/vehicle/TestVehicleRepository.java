package com.alten.vehicle;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alten.vehicle.model.Vehicle;
import com.alten.vehicle.repo.VehicleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class TestVehicleRepository {

	@Autowired
	VehicleRepository vehicleRepository;

	@Test
	public void testCreateVehicle() {
		String vehicleId = "V-123";
		String registrationNo = "R-123";
		Vehicle vehicle = new Vehicle(vehicleId, registrationNo);
		vehicle = vehicleRepository.save(vehicle);
		Assert.assertNotNull(vehicle.getId());
	}
}
