package com.bucur.multithreading.synchronization.ex2;

public class SynchronizedCounter {

    private int count = 0;

    public synchronized void increment() {
        // obtain lock
        count = count + 1;
    }
    // release lock

    public int getCount() {
        return count;
    }
}
