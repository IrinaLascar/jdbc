package org.example.dao;

import org.example.model.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarDao {
    public void createTable() throws SQLException;

    public void createCar (Car car) throws SQLException;

    public List<Car> readAllCars () throws SQLException;

    public void updateCar (Car updatedCar) throws SQLException;

    public void deleteCar (Integer carId) throws SQLException;

    public void dropTable() throws SQLException;
}
