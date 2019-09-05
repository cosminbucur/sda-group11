package com.sda.functional.interfaces.suppliers;

import java.util.Random;
import java.util.function.Supplier;

public class DemoSuppliers {

    public static void main(String[] args) {
        Supplier<Integer> randomNumberSupplier =
                () -> new Random().nextInt();

        int randomNumber = randomNumberSupplier.get();
    }
}
