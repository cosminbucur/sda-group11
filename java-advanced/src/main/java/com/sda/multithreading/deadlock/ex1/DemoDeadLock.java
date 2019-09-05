package com.sda.multithreading.deadlock.ex1;

/**
 * Thread 1 - I got printer - I need scanner (blocked)
 * Thread 2 - I got scanner - I need printer (blocked)
 */
public class DemoDeadLock {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Scanner scanner = new Scanner();

        Thread robert = new Thread(new PrintAndScan(printer, scanner));
        robert.start();

        Thread anca = new Thread(new ScanAndPrint(printer, scanner));
        anca.start();
    }
}
