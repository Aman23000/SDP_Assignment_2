package edu.bu.met.cs665;

import edu.bu.met.cs665.models.Car;
import edu.bu.met.cs665.models.Driver;
import edu.bu.met.cs665.models.Scooter;
import edu.bu.met.cs665.models.Shop;
import edu.bu.met.cs665.models.Taxi;
import edu.bu.met.cs665.models.Vehicle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeliverySystemTest {

    private Shop shop;
    private Driver driver1;
    private Driver driver2;
    private Driver driver3;

    @Before
    public void setUp() {
        // Initialize the shop and drivers for each test
        shop = new Shop();
        Vehicle car = new Car();
        Vehicle scooter = new Scooter();
        Vehicle taxi = new Taxi();

        driver1 = new Driver("Alice", car);
        driver2 = new Driver("Bob", scooter);
        driver3 = new Driver("Charlie", taxi);

        shop.registerObserver(driver1);
        shop.registerObserver(driver2);
        shop.registerObserver(driver3);
    }

    @Test
    public void testSingleDeliveryNotification() {
        // Create a single delivery request and notify all drivers
        shop.createDeliveryRequest("Laptop", "123 Main St");
        shop.notifyObservers();

        assertEquals("DeliveryRequest: Laptop to 123 Main St", driver1.getDeliveryRequest().toString());
        assertEquals("DeliveryRequest: Laptop to 123 Main St", driver2.getDeliveryRequest().toString());
        assertEquals("DeliveryRequest: Laptop to 123 Main St", driver3.getDeliveryRequest().toString());
    }

    @Test
    public void testMultipleDeliveryNotifications() {
        // Notify drivers about two different delivery requests
        shop.createDeliveryRequest("Laptop", "123 Main St");
        shop.notifyObservers();

        assertEquals("DeliveryRequest: Laptop to 123 Main St", driver1.getDeliveryRequest().toString());

        shop.createDeliveryRequest("Book", "456 Elm St");
        shop.notifyObservers();

        assertEquals("DeliveryRequest: Book to 456 Elm St", driver1.getDeliveryRequest().toString());
        assertEquals("DeliveryRequest: Book to 456 Elm St", driver2.getDeliveryRequest().toString());
        assertEquals("DeliveryRequest: Book to 456 Elm St", driver3.getDeliveryRequest().toString());
    }

    @Test
    public void testUnregisterObserver() {
        // Unregister one driver and ensure they no longer receive notifications
        shop.removeObserver(driver2);
        shop.createDeliveryRequest("Tablet", "789 Oak St");
        shop.notifyObservers();

        assertEquals("DeliveryRequest: Tablet to 789 Oak St", driver1.getDeliveryRequest().toString());
        assertNull(driver2.getDeliveryRequest()); // driver2 should not receive the request
        assertEquals("DeliveryRequest: Tablet to 789 Oak St", driver3.getDeliveryRequest().toString());
    }

    @Test
    public void testNoObservers() {
        // Remove all drivers and ensure no notifications are sent
        shop.removeObserver(driver1);
        shop.removeObserver(driver2);
        shop.removeObserver(driver3);

        shop.createDeliveryRequest("Monitor", "123 Pine St");
        shop.notifyObservers();

        assertNull(driver1.getDeliveryRequest());
        assertNull(driver2.getDeliveryRequest());
        assertNull(driver3.getDeliveryRequest());
    }

    @Test
    public void testAddObserverAfterNotification() {
        // Add a driver after a delivery request is created and notify them
        Driver driver4 = new Driver("David", new Taxi());
        shop.createDeliveryRequest("Smartphone", "999 Walnut St");
        shop.notifyObservers();

        // driver4 hasn't been added yet, so they won't receive this request
        assertNull(driver4.getDeliveryRequest());

        // Now add driver4 and send another notification
        shop.registerObserver(driver4);
        shop.createDeliveryRequest("Headphones", "1000 Birch St");
        shop.notifyObservers();

        assertEquals("DeliveryRequest: Headphones to 1000 Birch St", driver4.getDeliveryRequest().toString());
    }

    @Test
    public void testDeliveryRequestToSpecificDriver() {
        // Test that specific drivers get the correct delivery request after registration
        shop.createDeliveryRequest("Camera", "456 Elm St");
        shop.notifyObservers();

        assertEquals("DeliveryRequest: Camera to 456 Elm St", driver1.getDeliveryRequest().toString());
        assertEquals("DeliveryRequest: Camera to 456 Elm St", driver2.getDeliveryRequest().toString());
        assertEquals("DeliveryRequest: Camera to 456 Elm St", driver3.getDeliveryRequest().toString());
    }

    @Test
    public void testSameObserverMultipleTimes() {
        // Register the same observer multiple times and ensure they are notified only once
        shop.registerObserver(driver1); // Register driver1 again
        shop.createDeliveryRequest("Watch", "789 Oak St");
        shop.notifyObservers();

        assertEquals("DeliveryRequest: Watch to 789 Oak St", driver1.getDeliveryRequest().toString());
        assertEquals("DeliveryRequest: Watch to 789 Oak St", driver2.getDeliveryRequest().toString());
        assertEquals("DeliveryRequest: Watch to 789 Oak St", driver3.getDeliveryRequest().toString());
    }
}

