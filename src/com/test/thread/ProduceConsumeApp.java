package com.test.thread;


import java.util.Vector;
import java.util.concurrent.ExecutionException;

public class ProduceConsumeApp {
    static Vector sharedQueue = new Vector();
    static int size = 4;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Thread producer = new Thread(new Producer(sharedQueue, size), "Producer");
        Thread consumer = new Thread(new Consumer(sharedQueue, size), "Consumer");

        //FutureTask<Integer> future = new FutureTask<Integer>(new CallThread(sharedQueue, 4));
        //Thread callThread = new Thread(future);
        producer.start();
		/*ExecutorService executor = Executors.newFixedThreadPool(size);
		List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
		
		for(int i=0;i<10;i++)
		{
			futures.add(executor.submit(new CallThread(sharedQueue, 4)));
			
		} 
		for (Future<Integer> future : futures) {
			System.out.println("Result"+future.get());
		}*/

        //consumer.start();
        //callThread.start();
        //System.out.println("Result Main :"+future.get());
    }

}
