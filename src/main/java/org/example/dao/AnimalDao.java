package org.example.dao;

import org.example.model.Animal;

import java.sql.SQLException;

public interface AnimalDao {
    // Animal Data Access Object <- clasă pentru a accesa date din "animals"
    // manipulare structura baza de date (creare si stergere tabel)
// manipulare date - CRUD

    // creat table
    void createTable() throws SQLException;

    // adaugare date            CREATE animals
    void create (Animal animal) throws SQLException;

    // gasire date              READ animals

    // modificare date          UPDATE animals

    // stergere date            DELETE animals

    // șters tabel
    void dropTable() throws SQLException;

}

