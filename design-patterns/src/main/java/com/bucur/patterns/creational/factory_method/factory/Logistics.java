package com.bucur.patterns.creational.factory_method.factory;

import com.bucur.patterns.creational.factory_method.transports.Transport;

public abstract class Logistics {

    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }

    abstract Transport createTransport();
}
