package com.sda.oop.enums;

public class DemoSwitch {

    public static void main(String[] args) {
        LengthUnit inputLengthUnit = LengthUnit.METER;

        switch (inputLengthUnit) {
            case METER:
                System.out.println("meter selected");
                break;
            case CENTIMETER:
                System.out.println("centimeter selected");
                break;
        }

        int inputInt = 2;
        switch (inputInt) {

        }

        // can not use objects
//        Person person = new Person();
//        switch (person) {
//
//        }
    }
}
