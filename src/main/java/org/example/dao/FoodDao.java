package org.example.dao;

import org.example.model.Food;

import java.sql.SQLException;

// Food Data Access Object <- clasă pentru a accesa date din "foods"
// manipulare structura baza de date (creare si stergere tabel)
// manipulare date - CRUD
public interface FoodDao {

    // creat table
    void createTable() throws SQLException;

    // adaugare date            CREATE foods
    void create(Food food) throws SQLException;
    // gasire date              READ foods

    // modificare date          UPDATE foods

    // stergere date            DELETE foods

    // șters tabel
    void dropTable() throws SQLException;

}