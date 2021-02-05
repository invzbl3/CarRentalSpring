package com.project.carrental.dao.idao;

import com.project.carrental.entity.UserType;
import java.util.List;

/**
 * An interface for UserType DAO
 *
 */
public interface IUserTypeDao {

    public int insert(UserType userType);

    public int update(UserType userType);

    public int delete(UserType userType);

    public List<UserType> findAll();
}