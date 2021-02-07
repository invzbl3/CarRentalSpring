package com.project.carrental.repository;

import com.project.carrental.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> { }
