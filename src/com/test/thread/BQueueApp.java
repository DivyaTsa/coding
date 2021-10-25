package com.test.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BQueueApp {
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args) {
        System.out.println("Main Thread..");
        BQueueApp bq = new BQueueApp();
        try {
            bq.startApp();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void startApp() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    private void producer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            int num = random.nextInt(100);
            queue.put(num);
            System.out.println("Put value :" + num);
        }

    }

    private void consumer() throws InterruptedException {
        while (true) {
            int num = queue.take();
            System.out.println("Taken value :" + num);
        }
    }

}
