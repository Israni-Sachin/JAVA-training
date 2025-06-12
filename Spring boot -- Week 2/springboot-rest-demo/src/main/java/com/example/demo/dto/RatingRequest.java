package com.example.demo.dto;


public class RatingRequest {
    private int ambiance;
    private int food;
    private int service;
    private int cleanliness;
    private int drinks;

    public int getAmbiance() {
        return ambiance;
    }
    public int getFood() {
        return food;
    }
    public int getService() {
        return service;
    }
    public int getCleanliness() {
        return cleanliness;
    }
    public int getDrinks() {
        return drinks;
    }
    public void setAmbiance(int ambiance) {
        this.ambiance = ambiance;
    }
    public void setFood(int food) {
        this.food = food;
    }
    public void setService(int service) {
        this.service = service;
    }
    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }
    public void setDrinks(int drinks) {
        this.drinks = drinks;
    }

}
