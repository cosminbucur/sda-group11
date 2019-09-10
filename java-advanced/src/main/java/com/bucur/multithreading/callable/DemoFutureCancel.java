package com.bucur.multithreading.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoFutureCancel {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        long startTime = System.nanoTime();
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(2000);
            return "Hello from Callable";
        });

        while (!future.isDone()) {
            System.out.println("Task is still not done...");
            Thread.sleep(200);
            double elapsedTimeInSec = (System.nanoTime() - startTime) / 1000000000.0;

            if (elapsedTimeInSec > 1) {
                future.cancel(true);
            }
        }

//        System.out.println("Task completed! Retrieving the result");
//        String result = future.get();
//        System.out.println(result);

        if (!future.isCancelled()) {
            System.out.println("Task completed! Retrieving the result");
            String result = future.get();
            System.out.println(result);
        } else {
            System.out.println("Task was cancelled");
        }

        executorService.shutdown();
    }
}
