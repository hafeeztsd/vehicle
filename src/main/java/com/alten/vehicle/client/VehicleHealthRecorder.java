package com.alten.vehicle.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("vehicle-health-recorder")
public interface VehicleHealthRecorder {

	@RequestMapping(method = RequestMethod.POST, value = "/vehicle/{vehicleId}", consumes = "application/json")
	String ping(@PathVariable("vehicleId") String vehicleId, @RequestBody String status);

}
