package com.bucur.multithreading.callable;

import java.util.concurrent.Callable;

public class DemoCallable {

    public static void main(String[] args) {
        // old school
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                // Perform some computation
                Thread.sleep(2000);
                return "Return some result";
            }
        };

        // cool
        Callable<String> callable2 = () -> {
            // Perform some computation
            Thread.sleep(2000);
            return "Return some result";
        };
    }
}
