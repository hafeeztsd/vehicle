package com.alten.vehicle.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alten.vehicle.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String>{

}
