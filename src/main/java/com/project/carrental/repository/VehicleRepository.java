package com.project.carrental.repository;

import com.project.carrental.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.math.BigDecimal;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    /*@Query("select v.dailyPrice from Vehicle v where v.vehicleID =: vehicleID")
    BigDecimal getDailyPriceByVehicleID(Integer vehicleID);*/
    @Query("select v from Vehicle v where v.vehicleID =: id")
    Vehicle getDailyPriceByVehicleID(Integer vehicleID);
}
