package com.counter;

public class CounterApp {
    volatile static boolean shutdown = false;

    public static void main(String[] args) {
        Integer count = new Integer(0);
        int limit = 20;

        System.out.println("Counter App");
        Thread monitor = new Thread(new MonitorThread(count, limit, shutdown));
        Thread counter = new Thread(new CounterThread(count, shutdown));

        //monitor.start();
        counter.start();
    }


}
