package com.project.carrental.repository;

import com.project.carrental.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
     public BigDecimal findByVehicleID(int vehicleID);
}
