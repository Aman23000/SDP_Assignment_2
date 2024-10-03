package edu.bu.met.cs665;

import edu.bu.met.cs665.models.DeliveryRequest;

public interface Observer {
    void update(DeliveryRequest request);
}
