package com.project.carrental.dao.daofactory;

import com.project.carrental.dao.idao.*;

/**
 * Factory class for creating DAOs
 *
 */
public class DaoFactory {

    public static IUserTypeDao getUserTypeDAO() {
        return new UserTypeDaoImpl();
    }

    public static IUserDao getUserDAO() {
        return new UserDaoImpl();
    }

    public static IVehicleDao getVehicleDAO() {
        return new VehicleDaoImpl();
    }

    public static IPassportDao getPassportDAO() {
        return new PassportDaoImpl();
    }

    public static IOrderDao getOrderDAO() {
        return new OrderDaoImpl();
    }
}