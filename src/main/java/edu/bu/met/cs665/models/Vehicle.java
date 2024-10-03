package edu.bu.met.cs665.models;

public abstract class Vehicle {
    private String type;

    public Vehicle(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}