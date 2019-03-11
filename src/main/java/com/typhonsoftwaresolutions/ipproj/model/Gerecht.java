package com.typhonsoftwaresolutions.ipproj.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Gerecht {
    private int id;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 30)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 50)
    private Double price;

    public Gerecht() {
    }

    public Gerecht(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }
}
