package edu.bu.met.cs665.models;

import edu.bu.met.cs665.Observer;

public class Driver implements Observer {
    private final String name;
    private final Vehicle vehicle;
    private DeliveryRequest deliveryRequest;

    public Driver(String name, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }

    @Override
    public void update(DeliveryRequest request) {
        this.deliveryRequest = request;
        System.out.println(name + " with vehicle " + vehicle.getType() + " notified of " + request.toString());
    }

    public DeliveryRequest getDeliveryRequest() {
        return deliveryRequest;
    }

    @Override
    public String toString() {
        return "Driver " + name + " driving " + vehicle.getType();
    }
}
