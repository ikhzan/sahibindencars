package com.training.sahibindencars.models;

import androidx.annotation.NonNull;

public class Item {

    private String name, model, brand, price, country;

    public Item(){}

    public Item(String name, String model, String brand, String price, String country) {
        this.name = name;
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public String getPrice() {
        return price;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", price='" + price + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
