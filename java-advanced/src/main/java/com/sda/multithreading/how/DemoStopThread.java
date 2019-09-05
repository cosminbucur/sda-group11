package com.sda.multithreading.how;

public class DemoStopThread {

    public static void main(String[] args) {
        System.out.println("main thread: " + Thread.currentThread().getName());

        MyThread myThread = new MyThread();
        myThread.start();   // start a thread. don't use run()

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        myThread.stopRunning();
    }
}
