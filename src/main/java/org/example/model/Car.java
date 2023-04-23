package org.example.model;

import java.sql.Date;

public class Car {
    private Integer id;
    private String name;

    private Date anulFabricatiei;

    public Car() {
    }

    public Car(Integer id, String name, Date anulFabricatiei) {
        this.id = id;
        this.name = name;
        this.anulFabricatiei = anulFabricatiei;
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

    public Date getAnulFabricatiei() {
        return anulFabricatiei;
    }

    public void setAnulFabricatiei(Date anulFabricatiei) {
        this.anulFabricatiei = anulFabricatiei;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", anulFabricatiei=" + anulFabricatiei +
                '}';
    }
}
