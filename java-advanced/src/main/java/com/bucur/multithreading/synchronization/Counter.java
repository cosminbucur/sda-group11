package com.bucur.multithreading.synchronization;

public class Counter {

    private long count = 0;

    public synchronized void add(long value) {
//    public void add(long value) {
        this.count += value;
    }

    public long getCount() {
        return count;
    }
}
