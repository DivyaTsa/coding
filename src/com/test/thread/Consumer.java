package com.test.thread;

import java.util.Vector;

public class Consumer implements Runnable {
    Vector sharedQueue;
    int size;

    Consumer(Vector queue, int size) {
        this.sharedQueue = queue;
        this.size = size;
    }

    @Override
    public void run() {

        try {
            while (true)
                consume();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void consume() throws InterruptedException {
        while (sharedQueue.isEmpty()) {
            synchronized (sharedQueue) {

                System.out.println("Queue is empty waiting, " + Thread.currentThread().getName());
                sharedQueue.wait();
            }
        }

        synchronized (sharedQueue) {
            System.out.println("Consumed :" + sharedQueue.remove(0));
            sharedQueue.notifyAll();
        }

    }

}
