package com.bucur.solid.dependency_inversion.before;

public class ElectricPowerSwitch {

    public LightBulb lightBulb;
    public boolean on;

    public ElectricPowerSwitch(LightBulb lightBulb, boolean on) {
        this.lightBulb = lightBulb;
        this.on = on;
    }

    public boolean isOn() {
        return on;
    }

    public void press() {
        boolean checkOn = isOn();
        if (checkOn) {
            lightBulb.turnOff();
            this.on = false;
        } else {
            lightBulb.turnOn();
            this.on = true;
        }
    }
}
