package com.sda.spring.boot.rest.storage;

import java.util.ArrayList;
import java.util.List;

public class StorageRepository {

    List<StoragePoint> storagePoints = new ArrayList<>();

    public StorageRepository() {
        // create 2 storage points with 2 tires (2 worn - 1 worn, 1 new)
        StoragePoint storagePoint1 = new StoragePoint();
        storagePoint1.licensePlate = "B22ABC";

        Tire wornTire1 = new Tire(3);
        Tire wornTire2 = new Tire(3);

        storagePoint1.tires.add(wornTire1);
        storagePoint1.tires.add(wornTire2);

        StoragePoint storagePoint2 = new StoragePoint();
        storagePoint2.licensePlate = "B22DEF";

        Tire newTire1 = new Tire(1);
        Tire wornTire3 = new Tire(3);

        storagePoint2.tires.add(newTire1);
        storagePoint2.tires.add(wornTire3);
    }
}
