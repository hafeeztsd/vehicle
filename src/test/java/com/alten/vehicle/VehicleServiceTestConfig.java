package com.alten.vehicle;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.alten.vehicle.repo.VehicleRepository;
import com.alten.vehicle.service.VehicleScheduler;
import com.alten.vehicle.service.VehicleService;

@Configuration
@ComponentScan(basePackageClasses = { VehicleService.class })
public class VehicleServiceTestConfig {

	@Bean
	public VehicleRepository vehicleRepository() {
		return Mockito.mock(VehicleRepository.class);
	}

	@Bean
	public VehicleScheduler vehicleScheduler() {
		return Mockito.mock(VehicleScheduler.class);
	}

}
