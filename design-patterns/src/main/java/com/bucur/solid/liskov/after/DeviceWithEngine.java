package com.bucur.solid.liskov.after;

public class DeviceWithEngine extends TransportationDevice {

    private Engine engine;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void startEngine() {
        engine.start();
    }
}
