package com.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ConnectionPool {
    private static ConnectionPool connection = new ConnectionPool();
    Semaphore sem = new Semaphore(10);
    private int connections = 0;

    public static ConnectionPool getInstance() {
        return connection;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Connection pool!");
        ExecutorService ex = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            ex.submit(new Runnable() {

                @Override
                public void run() {
                    try {
                        ConnectionPool.getInstance().connect();
                        Thread.sleep(1);

                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } finally {
                        ConnectionPool.getInstance().disConnect();
                    }


                }
            });

        }

        ex.shutdown();

    }

    public void connect() throws InterruptedException {
        sem.acquire();
        synchronized (this) {

            connections++;
        }
        System.out.println("No of connections" + connections);
    }

    public void disConnect() {
        synchronized (this) {
            connections--;

        }
        sem.release();
        System.out.println("Disconnect:No of connections" + connections);
    }

}
