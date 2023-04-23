package org.example;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.example.dao.AnimalDao;
import org.example.dao.AnimalDaoImpl;
import org.example.dao.FoodDaoImpl;
import org.example.dao.FoodDao;
import org.example.model.Animal;

import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String dbLocation = "localhost:3306";
        String dbName = "jdbc_db";
        String dbUser = "root";
        String dbPassword = "030903"; //parola ptr baza de date

        MysqlDataSource dataSource = new MysqlDataSource();
// Formatul pentru url-ul de conectare la baza de date
// jdbc:mysql://<<locația server-ului de baze de data>>/<<numele bazei de date>>
// jdbc:mysql://localhost:3306/jdbc_db
        dataSource.setUrl("jdbc:mysql://" + dbLocation + "/" + dbName);
        dataSource.setUser(dbUser);
        dataSource.setPassword(dbPassword);

        try {

            LOGGER.log(Level.INFO, "Trying to connect to DB");
            Connection connection = dataSource.getConnection();
            LOGGER.log(Level.INFO, "Connection successful");

            AnimalDao animalDao = new AnimalDaoImpl(connection);
            FoodDao foodDao = new FoodDaoImpl(connection);


            //
            Statement statement = connection.createStatement();

            animalDao.createTable();

            animalDao.create(new Animal(null, "Rex", "dog"));
            animalDao.create(new Animal(null, "Lucky", "dog"));
            animalDao.create(new Animal(null, "Lulu", "cat"));


            foodDao.createTable();



            LOGGER.info("Create tables animals and food was successful");
            statement.execute("insert into animals (name, species) values (\"Labus\", \"Dog\")");
            LOGGER.info("Data insertion was successful"); //creare baza de date si inserare date

            statement.execute("Update Animals Set Name = \"Oscar\" where id=1");


            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into food (name, description, calories_per_100, expiration_date) values (?, ?, ?, ?)");
            preparedStatement.setString(1, "ciocolată");
            preparedStatement.setString(2, "ciocolată de casă");
            preparedStatement.setInt(3, 550);
            Date expirationDate = Date.valueOf("2024-10-12");
            preparedStatement.setDate(4, expirationDate);
            //intotdeauna trebuie rulat: execute" daca vrem sa fie executat codul sql pe baza de date
            preparedStatement.execute();

            preparedStatement.setString(1, "alune");
            preparedStatement.setString(2, "punga alune");
            preparedStatement.setInt(3, 600);
            preparedStatement.setDate(4, expirationDate);
            preparedStatement.execute();

            ResultSet rs = statement.executeQuery("SELECT * FROM animals");
            System.out.println("Animals:");
            while (rs.next() == true) {
                System.out.println("Id: " + rs.getInt(1));
                System.out.println("Name: " + rs.getString((2)));
                System.out.println("Species: " + rs.getString((3)));
                System.out.println(": " + rs.getInt(1));
            }
// display all foods :D
//            Food:
//              1. ciocolata - ciocolata de casa - 550kcal per 100g - expiră la 2024-10-12
//              2. alune - pungă de 500g de alune prajite - 600kcal per 100g - expiră la 2024-10-12

            System.out.println("**********************************************");

            ResultSet rs2 = statement.executeQuery("SELECT * FROM food where calories_per_100 < 600 ");
            System.out.println("Foods: ");
            while (rs2.next()) {
                System.out.print("id. " + rs2.getInt(1) + " - ");
                System.out.print(rs2.getString(2) + " - ");
                System.out.print(rs2.getString(3) + " - ");
                System.out.print(rs2.getInt(4) + "kcal per 100g - ");
                System.out.print("expiră la " + rs2.getDate(5));
                System.out.println();
            }

            animalDao.dropTable();
            foodDao.dropTable();
            LOGGER.info("Tables dropped successfully");

        } catch (SQLException sqlException) {
            LOGGER.log(Level.SEVERE, "Error when connecting to database " + dbName
                    + " from " + dbLocation
                    + " with user " + dbUser);
            sqlException.printStackTrace(); //ptr print cu object-ul sqlException
        }
    }
}