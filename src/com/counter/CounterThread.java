package com.counter;

public class CounterThread implements Runnable {
    private Integer count;
    private volatile boolean shutdown;

    CounterThread(int count, boolean shutdown) {
        this.count = count;
        this.shutdown = shutdown;

    }

    @Override
    public void run() {

        try {
            while (true)
                increment();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void increment() throws InterruptedException {
        while (shutdown) {
            System.out.println("Stop thread");
            Thread.currentThread().stop();
        }
        synchronized (count) {
            count = count.intValue() + 1;
            System.out.println("Counter Thread : Counter Incremented" + count);
            count.notifyAll();
        }

    }

}
