package com.sda.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The ExecutorService interface contains a large number of methods for controlling the progress
 * of the tasks and managing the termination of the service. Using this interface, you can submit
 * the tasks for execution and also control their execution using the returned Future instance.
 */
public class DemoExecutorService {

    public static void main(String[] args) {
        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Executor Service...");
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        System.out.println("Creating a Runnable...");
        Runnable runnable = () -> {
            System.out.println("Inside : " + Thread.currentThread().getName());
        };

        System.out.println("Submit the task specified by the runnable to the executor service.");
        executorService.submit(runnable);

        System.out.println("Shutting down the executor");
        executorService.shutdown();
    }
}
