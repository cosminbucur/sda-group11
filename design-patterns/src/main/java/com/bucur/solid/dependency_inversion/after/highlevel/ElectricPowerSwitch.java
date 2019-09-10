package com.bucur.solid.dependency_inversion.after.highlevel;

public class ElectricPowerSwitch implements Switch {

    public Switchable switchable;
    public boolean on;

    public ElectricPowerSwitch(Switchable switchable, boolean on) {
        this.switchable = switchable;
        this.on = on;
    }

    public boolean isOn() {
        return on;
    }

    public void press() {
        boolean checkOn = isOn();
        if (checkOn) {
            switchable.turnOff();
            this.on = false;
        } else {
            switchable.turnOn();
            this.on = true;
        }
    }
}
