package com.example.demo.entity;

import jakarta.persistence.*;


@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private int ambiance;
    private int food;
    private int drinks;
    private int service;
    private int cleanliness;


//
//    // Parameterized constructor (optional)
//    public Rating(String ambiance, String food, String drinks, String service, String cleanliness) {
//        this.ambiance = ambiance;
//        this.food = food;
//        this.drinks = drinks;
//        this.service = service;
//        this.cleanliness = cleanliness;
//    }

    // Getters and Setters
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setAmbiance(String ambiance) {
//        this.ambiance = ambiance;
//    }
//
//    public void setFood(String food) {
//        this.food = food;
//    }
//
//    public void setDrinks(String drinks) {
//        this.drinks = drinks;
//    }
//
//    public void setService(String service) {
//        this.service = service;
//    }
//
//    public void setCleanliness(String cleanliness) {
//        this.cleanliness = cleanliness;
//    }

    public int getAmbiance() {
        return ambiance;
    }
    public void setAmbiance(int ambiance) {
        this.ambiance = ambiance;
    }
    public int getFood() {
        return food;
    }
    public void setFood(int food) {
        this.food = food;
    }
    public int getDrinks() {
        return drinks;
    }
    public void setDrinks(int drinks) {
        this.drinks = drinks;
    }
    public int getService() {
        return service;
    }
    public void setService(int service) {
        this.service = service;
    }
    public int getCleanliness() {
        return cleanliness;
    }
    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
