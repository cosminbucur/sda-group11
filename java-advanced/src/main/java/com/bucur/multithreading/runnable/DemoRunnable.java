package com.bucur.multithreading.runnable;

import java.util.Arrays;
import java.util.List;

public class DemoRunnable {

    public static void main(String[] args) {

        Runnable task = () -> System.out.println("running");
        Thread worker = new Thread(task);
        worker.start();

        // old school runnable
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello from runnable");
            }
        };

        // runnable with lambda
        Runnable greetingRunnable = () -> System.out.println("hello from runnable");
        Thread thread = new Thread(greetingRunnable);

        final List<String> names = Arrays.asList("ana", "alex", "sorin");
        Runnable namePrinter = () -> {
            System.out.println("hello from runnable");
            names.forEach(name -> System.out.println(name));
        };

        Thread thread2 = new Thread(namePrinter);

        thread.start();
        thread2.start();
    }
}

