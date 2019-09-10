package com.bucur.solid.liskov.after;

public class DemoLiskov {

    public static void main(String[] args) {
        DeviceWithoutEngine bike = new Bike();
        bike.startMoving();

        Engine engine = new Engine();
        DeviceWithEngine car = new Car();
        car.setEngine(engine);
        car.startEngine();
    }
}
