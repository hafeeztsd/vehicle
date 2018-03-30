package com.alten.vehicle;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.alten.vehicle.client.VehicleHealthRecorder;
import com.alten.vehicle.config.Properties;
import com.alten.vehicle.repo.VehicleRepository;
import com.alten.vehicle.service.VehicleScheduler;

@Configuration
@ComponentScan(basePackageClasses = { VehicleScheduler.class })
public class VehicleSchedulerTestConfig {

	@Bean
	public VehicleRepository vehicleRepository() {
		return Mockito.mock(VehicleRepository.class);
	}

	@Bean
	public VehicleHealthRecorder vehicleCustomerAggregator() {
		return Mockito.mock(VehicleHealthRecorder.class);
	}
	
	@Bean
	public Properties properties() {
		Properties properties = Mockito.mock(Properties.class);
		Mockito.when(properties.getPingDelay()).thenReturn(60000L);
		return properties;
	}
}
