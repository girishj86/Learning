package com.learning.java.threads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTask callableTask = new CallableTask();
        FutureTask<Integer>[] results = new FutureTask[5];
        for(int i=0;i<5;i++){
            results[i] = new FutureTask<Integer>(callableTask);
            Thread thread = new Thread(results[i]);
            thread.start();
        }
        for(int i=0;i<5;i++){
            FutureTask<Integer> futureTask = results[i];
            System.out.println("Getting result from future task "+i);
            System.out.println(futureTask.get());
        }
    }
}

class CallableTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Random random = new Random();
        Thread.sleep(3000);
        Integer num = random.nextInt(100);
        System.out.println("Number generated = "+num);
        return num;
    }
}