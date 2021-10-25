package com.test.thread;

import java.util.Vector;

public class Producer implements Runnable {
    Vector sharedQueue;
    int size;

    Producer(Vector queue, int size) {
        this.sharedQueue = queue;
        this.size = size;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            try {
                produce(i);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //return "True";
    }

    private void produce(int i) throws InterruptedException {
        while (sharedQueue.size() == size) {
            synchronized (sharedQueue) {
                System.out.println("The queue is full, waiting.." + sharedQueue.size());

                sharedQueue.wait();

            }
        }
        synchronized (sharedQueue) {
            System.out.println("Produced :" + i);
            sharedQueue.add(i);
            sharedQueue.notifyAll();
        }
    }

}
