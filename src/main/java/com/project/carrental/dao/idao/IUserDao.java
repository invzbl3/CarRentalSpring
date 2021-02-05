package com.project.carrental.dao.idao;

import com.project.carrental.entity.User;
import java.util.List;

/**
 * An interface for User DAO
 *
 */
public interface IUserDao {

    public int insert(User user);

    public int update(User user);

    public int delete(User user);

    public List<User> findAll();

    public User findByLogin(String loginParam);

    public User findByID(int userIDParam);
}