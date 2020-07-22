package com.training.sahibindencars.models;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Restaurant {
    public static final String FIELD_CITY = "city";
    public static final String FIELD_CATEGORY = "category";
    public static final String FIELD_PRICE = "price";
    public static final String FIELD_POPULARITY = "numRatings";
    public static final String FIELD_AVG_RATING = "avgRating";

    private String name;
    private String city;
    private String category;
    private String photo;
    private int price;
    private int numRatings;
    private double avgRating;

    public Restaurant(){}

    public Restaurant(String name, String city, String category, String photo, int price, int numRatings, double avgRating) {
        this.name = name;
        this.city = city;
        this.category = category;
        this.photo = photo;
        this.price = price;
        this.numRatings = numRatings;
        this.avgRating = avgRating;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCategory() {
        return category;
    }

    public String getPhoto() {
        return photo;
    }

    public int getPrice() {
        return price;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNumRatings(int numRatings) {
        this.numRatings = numRatings;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }
}
