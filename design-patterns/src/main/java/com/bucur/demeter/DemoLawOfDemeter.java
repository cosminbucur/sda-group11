package com.bucur.demeter;

import com.bucur.demeter.contract.IAddress;
import com.bucur.demeter.contract.IHouse;
import com.bucur.demeter.contract.IPerson;
import com.bucur.demeter.domain.Address;
import com.bucur.demeter.domain.House;
import com.bucur.demeter.domain.Person;

public class DemoLawOfDemeter {

    public static void main(String[] args) {
        IAddress address = new Address(
                "0234", "2B",
                "unirii", "Bucharest",
                "Romania", "Romania");
        IHouse house = new House(address, "yellow", 100.0);
        IPerson person = new Person("andrei", house);

        // violates the Demeter Law
        System.out.println(
                person.getHouse()   // house object
                        .getAddress()   // address object
                        .getZipCode());   // string zip code

        person.getHouse().getAddress().getZipCode();

        // respects the Demeter Law
        System.out.println(person.getZipCode());
    }
}
