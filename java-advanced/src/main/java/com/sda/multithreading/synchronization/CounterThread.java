package com.sda.multithreading.synchronization;

public class CounterThread extends Thread {

    private Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.add(i);
            System.out.println("Thread " + Thread.currentThread().getName() + " counter = " + this.counter.getCount());
        }
    }
}
