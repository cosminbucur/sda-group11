package com.bucur.patterns.creational.factory_method.factory;

import com.bucur.patterns.creational.factory_method.transports.Transport;
import com.bucur.patterns.creational.factory_method.transports.Truck;

public class RoadLogistics extends Logistics {

    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
