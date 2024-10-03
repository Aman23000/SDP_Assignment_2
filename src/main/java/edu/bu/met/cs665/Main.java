package edu.bu.met.cs665;

import edu.bu.met.cs665.models.Car;
import edu.bu.met.cs665.models.Driver;
import edu.bu.met.cs665.models.Scooter;
import edu.bu.met.cs665.models.Shop;
import edu.bu.met.cs665.models.Taxi;
import edu.bu.met.cs665.models.Vehicle;

public class Main {
  public static void main(String[] args) {
    // Create a shop (observable)
    Shop shop = new Shop();

    // Create vehicles
    Vehicle car = new Car();
    Vehicle scooter = new Scooter();
    Vehicle taxi = new Taxi();

    // Create drivers (observers)
    Driver driver1 = new Driver("James", car);
    Driver driver2 = new Driver("Bob", scooter);
    Driver driver3 = new Driver("Edward", taxi);

    // Register drivers with the shop
    shop.registerObserver(driver1);
    shop.registerObserver(driver2);
    shop.registerObserver(driver3);

    // Create and notify drivers of a new delivery request
    shop.createDeliveryRequest("Groceries", "123 Main St");
    shop.notifyObservers();
  }
}
