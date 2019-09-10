package com.bucur.demeter.domain;

import com.bucur.demeter.contract.IAddress;

public class Address implements IAddress {

    private String zipCode;
    private String number;
    private String street;
    private String city;
    private String state;
    private String country;

    public Address(String zipCode, String number, String street, String city, String state, String country) {
        this.zipCode = zipCode;
        this.number = number;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    @Override
    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public String getCounty() {
        return country;
    }
}
