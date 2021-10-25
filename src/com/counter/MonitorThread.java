package com.counter;

public class MonitorThread implements Runnable {
    private Integer count;
    private int limit;
    private volatile boolean shutdown;

    MonitorThread(int count, int limit, boolean shutdown) {
        this.count = count;
        this.limit = limit;
        this.shutdown = shutdown;
    }

    @Override
    public void run() {
        try {
            while (true)
                monitor();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void monitor() throws InterruptedException {
        while (shutdown == false) {
            synchronized (count) {
                System.out.println("Monitor T :Counter is not reached limit, waiting.." + count);
                count.wait();
            }
        }

        synchronized (count) {
            if (count == limit) {
                System.out.println(" Monitor T :Stop counter" + count);
                this.shutdown = true;
                count.notifyAll();
            }

        }

    }


}
