package com.mht.redisdemo.dto;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private String model;
    private String description;


    public Product(String name, String model, String description) {
        this.name = name;
        this.model = model;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
