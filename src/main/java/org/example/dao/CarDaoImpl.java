package org.example.dao;

import org.example.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {
    private final Connection connection;

    public CarDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("Create table if not exists cars " +
                " (id integer auto_increment primary key," +
                " name varchar(30), " +
                "anul_fabricatiei date);");

    }
    @Override
    public void createCar(Car car) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into cars (name, anul_fabricatiei) values(?,?)");
        preparedStatement.setString(1, car.getName());
        preparedStatement.setDate(2, car.getAnulFabricatiei());
        preparedStatement.execute();
    }

    @Override
    public List<Car> readAllCars() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM cars");
        List<Car> carList = new ArrayList<>();
        while (rs.next() == true){
            Car car = new Car();
            car.setName(rs.getString(2));
            car.setAnulFabricatiei(rs.getDate(3));
            car.setId(rs.getInt(1));
            carList.add(car);
        }
        return carList;
    }

    @Override
    public void updateCar(Car updatedCar) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update cars set name = ?, anul_fabricatiei = ? where id=?;");
        preparedStatement.setString(1, updatedCar.getName());
        preparedStatement.setDate(2, updatedCar.getAnulFabricatiei());
        preparedStatement.setInt(3, updatedCar.getId());
        preparedStatement.executeUpdate();
    }
    @Override
    public void deleteCar(Integer carId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "delete from Cars where id = ?"
        );
        preparedStatement.setInt(1, carId);
        preparedStatement.execute();
    }
    @Override
    public void dropTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("drop table cars");
    }
}
