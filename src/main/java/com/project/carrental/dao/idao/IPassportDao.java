package com.project.carrental.dao.idao;

import com.project.carrental.entity.Passport;
import java.util.List;

/**
 * An interface for Passport DAO
 *
 */
public interface IPassportDao {

    public int insert(Passport passport);

    public int update(Passport passport);

    public int delete(Passport passport);

    public List<Passport> findAll();

    public Passport findByID(int passportIDParam);
}