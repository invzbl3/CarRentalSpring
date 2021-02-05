package com.project.carrental.dao.idao;

import com.project.carrental.entity.Order;
import java.util.List;

/**
 * An interface for Order DAO
 *
 */
public interface IOrderDao {

    public int insert(Order order);

    public int update(Order order);

    public int delete(Order order);

    public List<Order> findAll();

    public Order findByID(int orderIDParam);
}