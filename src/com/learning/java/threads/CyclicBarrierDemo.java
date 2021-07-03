package com.learning.java.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String args[]) {
		/* creating CyclicBarrier with 3 parties i.e. 3 Threads needs to call await()
		This is main thread. Below task will execute once all threads called await()
		*/
		        CyclicBarrier cb = new CyclicBarrier(3, new Runnable(){
		            @Override
		            public void run(){
		                //This task will be executed once all thread reaches barrier
		                System.out.println("All parties are arrived at barrier, lets move");
		            }
		        });

		        Thread t1 = new Thread(new CyclicBarrierTask(cb), "Thread 1");
		        Thread t2 = new Thread(new CyclicBarrierTask(cb), "Thread 2");
		        Thread t3 = new Thread(new CyclicBarrierTask(cb), "Thread 3");

		        t1.start();
		        t2.start();
		        t3.start();
		    }

}

class CyclicBarrierTask implements Runnable {

    private CyclicBarrier barrier;

    public CyclicBarrierTask(CyclicBarrier barrier) {
        this.barrier = barrier;
        
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is waiting on first barrier");
            barrier.await();
            System.out.println(Thread.currentThread().getName() + " has crossed the first barrier");
            Thread.sleep(3000);
            //re-use the same cyclic barrier
            System.out.println(Thread.currentThread().getName() + " is waiting on second barrier");
            barrier.await();
            System.out.println(Thread.currentThread().getName() + " is done");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
