package com.project.carrental.repository;

import com.project.carrental.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    public <S extends Order> S save(S s);
    public void delete(Integer integer);
    public List<Order> findAll();
    public Order findOne(Integer integer);
}
