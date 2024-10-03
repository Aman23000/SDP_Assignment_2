package edu.bu.met.cs665.models;

import edu.bu.met.cs665.Observable;
import edu.bu.met.cs665.Observer;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private DeliveryRequest currentRequest;

    public void createDeliveryRequest(String product, String location) {
        currentRequest = new DeliveryRequest(product, location);
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(currentRequest);
        }
    }
}
