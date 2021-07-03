package com.learning.java.threads;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinRecursiveTaskDemo {
	static final int SIZE = 10_000_000;
    static int[] array = randomArray();
 
    public static void main(String[] args) {
 
        ArrayCounter mainTask = new ArrayCounter(array, 0, SIZE);
        ForkJoinPool pool = new ForkJoinPool();
        Integer evenNumberCount = pool.invoke(mainTask);
 
        System.out.println("Number of even numbers: " + evenNumberCount);
    }
 
    static int[] randomArray() {
        int[] array = new int[SIZE];
        Random random = new Random();
 
        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(100);
        }
 
        return array;
    }
}

class ArrayCounter extends RecursiveTask<Integer> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int[] array;
    int threshold = 100_000;
    int start;
    int end;
 
    public ArrayCounter(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }
 
    protected Integer compute() {
        if (end - start < threshold) {
            return computeDirectly();
        } else {
            int middle = (end + start) / 2;
 
            ArrayCounter subTask1 = new ArrayCounter(array, start, middle);
            ArrayCounter subTask2 = new ArrayCounter(array, middle, end);
 
            invokeAll(subTask1, subTask2);
 
 
            return subTask1.join() + subTask2.join();
        }
    }
 
    protected Integer computeDirectly() {
        Integer count = 0;
 
        for (int i = start; i < end; i++) {
            if (array[i] % 2 == 0) {
                count++;
            }
        }
 
        return count;
    }
}
