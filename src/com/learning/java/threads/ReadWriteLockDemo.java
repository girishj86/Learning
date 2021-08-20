package com.learning.java.threads;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        Storage storage = new Storage();
        for(int i=1;i<=3;i++) {
            ReadThread readThread = new ReadThread(storage);
            readThread.setName("ReadThread - "+i);
            readThread.start();
        }
        WriteThread writeThread = new WriteThread(storage);
        writeThread.setName("WriteThread");
        writeThread.start();
    }
}

class ReadThread extends Thread {
    Storage storage;

    public ReadThread(Storage storage) {
        this.storage = storage;
    }

    public void run(){
        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!storage.queue.isEmpty()) {
                System.out.println("Trying to read by " + Thread.currentThread().getName());
                System.out.println(storage.read());
            }
        }
    }
}

class WriteThread extends Thread {
    Storage storage;

    public WriteThread(Storage storage) {
        this.storage = storage;
    }

    public void run(){
       for(int i=1;i<=5;i++) {
           System.out.println("Writing to queue by "+Thread.currentThread().getName());
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           storage.write(i);
       }
    }
}

class Storage {
    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();
    Queue<Integer> queue = new LinkedList<>();

    public void write(Integer num){
        try {
            writeLock.lock();
            queue.offer(num);
        } finally {
            writeLock.unlock();
        }
    }

    public Integer read(){

        try {
            readLock.lock();
            return queue.poll();
        } finally {
            readLock.unlock();
        }

    }
}