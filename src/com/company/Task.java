package com.company;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

import java.util.concurrent.Executors;

public class Task {


    public static void main(String[] args) throws InterruptedException {

        Executor executor = Executors.newFixedThreadPool(5);
        int concurrency=5;
        Runnable action = () -> {
            int i =0;
            int j=0;
            while(j<1000000000){
                j++;
                while(i<1000000000)
                i++;
            }
            System.out.println(Thread.currentThread().getName());
        };
        System.out.println(time(executor,concurrency,action));

    }
    public static long time(Executor executor, int concurrency,
                            Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done  = new CountDownLatch(concurrency);
        for (int i = 0; i < concurrency; i++) {
            int finalI = i;
            executor.execute(() -> {
                System.out.println("before ready.countdown :  "+ finalI + " " +System.nanoTime());
                ready.countDown(); // Tell timer we're ready
                System.out.println("after ready.countdown :  "+ finalI +" " + System.nanoTime());
                try {
                    start.await(); // Wait till peers are ready
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown();  // Tell timer we're done
                }
            }); }
        System.out.println("before ready.await "+ System.nanoTime());
        ready.await(); // Wait for all workers to be ready
         long startNanos = System.nanoTime();
        System.out.println(startNanos);
         start.countDown(); // And they're off!
        done.await(); // Wait for all workers to finish
        return System.nanoTime();
    }

}
