package com.learning.java.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        /*System.out.println("Synchronized Producer Consumers");
        Queue<Integer> queue = new LinkedList<>();
        SynchronizedProducer synchronizedProducer = new SynchronizedProducer(queue);
        SynchronizedConsumer synchronizedConsumer = new SynchronizedConsumer(queue);
        Thread synchronizedProducerThread = new Thread(synchronizedProducer);
        Thread synchronizedConsumerThread = new Thread(synchronizedConsumer);
        synchronizedProducerThread.start();
        synchronizedConsumerThread.start();*/

        System.out.println("Blocking Queue Producer Consumers");
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        BlockingQueueProducer blockingQueueProducer = new BlockingQueueProducer(blockingQueue);
        BlockingQueueConsumer blockingQueueConsumer = new BlockingQueueConsumer(blockingQueue);
        Thread blockingQueueProducerThread = new Thread(blockingQueueProducer);
        Thread blockingQueueConsumerThread = new Thread(blockingQueueConsumer);
        blockingQueueProducerThread.start();
        blockingQueueConsumerThread.start();
    }
}

class SynchronizedProducer implements Runnable {

    Queue<Integer> queue;

    public SynchronizedProducer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (this.queue) {
                while (!queue.isEmpty()) {
                    try {
                        this.queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.queue.offer(i);
                System.out.println("Producer produced " + i);
                this.queue.notifyAll();
            }
        }
    }
}

class SynchronizedConsumer implements Runnable {

    Queue<Integer> queue;

    public SynchronizedConsumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (this.queue) {
                while (queue.isEmpty()) {
                    try {
                        this.queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Consumer consumed " + this.queue.poll());
                this.queue.notifyAll();
            }
        }
    }
}

class BlockingQueueProducer implements Runnable{

    BlockingQueue<Integer> queue;

    public BlockingQueueProducer(BlockingQueue<Integer> blockingQueue) {
        this.queue = blockingQueue;
    }

    @Override
    public void run() {
        int counter = 0;
        while(counter < 10){
            System.out.println("Producer produced "+counter);
            queue.offer(counter++);
        }
    }
}

class BlockingQueueConsumer implements Runnable{

    BlockingQueue<Integer> queue;

    public BlockingQueueConsumer(BlockingQueue<Integer> blockingQueue) {
        this.queue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(!queue.isEmpty()){
            System.out.println("Consumer consumed "+queue.poll());
        }
    }
}