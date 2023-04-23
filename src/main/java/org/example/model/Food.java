package org.example.model;

import java.sql.Date;

public class Food {
    private Integer id;
    private String name;
    private String description;
    private Integer caloriesPer100;
    private Date expirationDate;

    public Food() {
    }

    public Food(Integer id, String name, String description, Integer caloriesPer100, Date expirationDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.caloriesPer100 = caloriesPer100;
        this.expirationDate = expirationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCaloriesPer100() {
        return caloriesPer100;
    }

    public void setCaloriesPer100(Integer caloriesPer100) {
        this.caloriesPer100 = caloriesPer100;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
