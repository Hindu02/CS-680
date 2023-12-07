package edu.umb.cs680.hw12;


class Car {

    // private variables for Car Class
    private String make;
    private float price;
    private String model;
    private int mileage;
    private int year;
    private int dominationCount;


    //constructor
    public Car(String make, float price, String model, int mileage, int year) {
        this.make = make;
        this.year = year;
        this.model = model;
        this.mileage = mileage;
        this.price = price;
    }

    // getter methods

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public int getDominationCount() {
        return dominationCount;
    }

    public void setDominationCount(int newDominationCount) {
        this.dominationCount = newDominationCount;
    }

}