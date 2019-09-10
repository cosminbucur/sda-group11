package com.bucur.demeter.domain;

import com.bucur.demeter.contract.IHouse;
import com.bucur.demeter.contract.IPerson;

public class Person implements IPerson {

    private String name;
    private IHouse house;

    public Person(String name, IHouse house) {
        this.name = name;
        this.house = house;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IHouse getHouse() {
        return house;
    }

    @Override
    public String getZipCode() {
        return house.getZipCode();
    }
}
