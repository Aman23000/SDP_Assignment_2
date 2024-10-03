package edu.bu.met.cs665.models;

public class DeliveryRequest {
    private String product;
    private String location;

    public DeliveryRequest(String product, String location) {
        this.product = product;
        this.location = location;
    }

    public String getProduct() {
        return product;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "DeliveryRequest: " + product + " to " + location;
    }
}
