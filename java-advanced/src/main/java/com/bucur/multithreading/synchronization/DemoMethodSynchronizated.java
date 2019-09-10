package com.bucur.multithreading.synchronization;

public class DemoMethodSynchronizated {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new CounterThread(counter);
        Thread thread2 = new CounterThread(counter);

        thread1.start();
        thread2.start();
    }

}
