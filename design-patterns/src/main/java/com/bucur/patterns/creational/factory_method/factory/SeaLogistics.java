package com.bucur.patterns.creational.factory_method.factory;

import com.bucur.patterns.creational.factory_method.transports.Ship;
import com.bucur.patterns.creational.factory_method.transports.Transport;

public class SeaLogistics extends Logistics {

    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
