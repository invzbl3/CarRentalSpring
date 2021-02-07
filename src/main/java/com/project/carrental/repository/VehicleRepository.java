package com.project.carrental.repository;

import com.project.carrental.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    public <S extends Vehicle> S save(S s);
    public void delete(Integer integer);
    public List<Vehicle> findAll();
    public Vehicle findOne(Integer integer);
    // findDailyPriceByVehicleID
}
