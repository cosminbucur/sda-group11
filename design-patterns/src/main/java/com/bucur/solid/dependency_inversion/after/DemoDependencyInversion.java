package com.bucur.solid.dependency_inversion.after;

import com.bucur.solid.dependency_inversion.after.highlevel.ElectricPowerSwitch;
import com.bucur.solid.dependency_inversion.after.highlevel.Switch;
import com.bucur.solid.dependency_inversion.after.highlevel.Switchable;
import com.bucur.solid.dependency_inversion.after.lowlevel.Fan;
import com.bucur.solid.dependency_inversion.after.lowlevel.LightBulb;

public class DemoDependencyInversion {

    public static void main(String[] args) {
        Switchable lightBulb = new LightBulb();
        Switchable fan = new Fan();

        Switch lightBulbSwitch = new ElectricPowerSwitch(lightBulb, true);
        Switch fanSwitch = new ElectricPowerSwitch(fan, false);

        lightBulbSwitch.press();
        fanSwitch.press();  // on
        fanSwitch.press();  // off
    }
}
