package com.bucur.multithreading.how;

public class MyThread extends Thread {

    private volatile boolean flag = true;

    public void stopRunning() {
        flag = false;
    }

    @Override
    public void run() {
        System.out.println("my thread: " + Thread.currentThread().getName());

        while (flag) {
            System.out.println("running...");
        }

        System.out.println("stopped running...");
    }
}
