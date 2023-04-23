package org.example.dao;

import org.example.dao.FoodDao;
import org.example.model.Food;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FoodDaoImpl implements FoodDao {

    private final Connection connection;

    public FoodDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("create table if not exists food (" +
                "id integer auto_increment, " +
                "name varchar(100), " +
                "description varchar(100)," +
                "calories_per_100 integer, " +
                "expiration_date date, " +
                "primary key (id) )");
    }

    @Override
    public void create(Food food) throws SQLException {

    }

    @Override
    public void dropTable() throws SQLException{
        Statement statement = connection.createStatement();
        statement.execute("drop table food");
    }
}














