package com.project.carrental.repository;

import com.project.carrental.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query("select v from vehicles v where v.vehicleID =:id")
    Vehicle getDailyPriceByVehicleID(Integer vehicleID);

    @Override
    Page<Vehicle> findAll(Pageable pageable);

}
