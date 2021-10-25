package com.test.thread;

import java.util.Vector;
import java.util.concurrent.Callable;

public class CallThread implements Callable<Integer> {
    Vector<Integer> sharedQueue;
    int size;

    CallThread(Vector<Integer> queue, int size) {
        this.sharedQueue = queue;
        this.size = size;
    }

    @Override
    public Integer call() throws Exception {
        while (sharedQueue.isEmpty()) {
            synchronized (sharedQueue) {

                sharedQueue.wait();
            }
        }
        synchronized (sharedQueue) {
            int num = sharedQueue.remove(sharedQueue.size() - 1);
            System.out.println("Consumed :" + num);
            sharedQueue.notifyAll();
            return num;
        }
    }

}
