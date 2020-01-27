package com.sda.spring.boot.rest.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {
        StorageRepository storageRepository = new StorageRepository();

    }

    // get all worn tyres

    public static Map<String, List<Tire>> getAllWornTyresByLicensePlate(List<StoragePoint> storagePoints) {
        Map<String, List<Tire>> result = new HashMap<>();

        // PUT in map <licensePlate, list of wornTyres)

        return result;
    }

    public List<Tire> getAllWornTyres(List<StoragePoint> storagePoints) {
        List<Tire> result = new ArrayList<>();

        for (int i = 0; i < storagePoints.size(); i++) {
            result.addAll(getWornTyres(storagePoints.get(i)));
        }

        return result;
    }

    public List<Tire> getWornTyres(StoragePoint storagePoint) {
        List<Tire> tires = storagePoint.tires;
        List<Tire> result = new ArrayList<>();

        for (Tire tire : tires) {
            if (tire.wearLevel < 3) {
                result.add(tire);
            }
        }

        return result;
    }
}
