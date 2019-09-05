package com.sda.multithreading.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoFutureIsDone {

    public static void main(String[] args) throws InterruptedException, ExecutionException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(() -> {
            Thread.sleep(2000);
            return "Hello from Callable";
        });

        while (!future.isDone()) {
            System.out.println("Task is still not done...");
            Thread.sleep(200);
        }

        System.out.println("Task completed! Retrieving the result");
        String result = future.get();
        System.out.println(result);

        executorService.shutdown();
    }
}
