package com.test.thread;

public class MyDeadLock {
    String str1 = "Hello";
    String str2 = "World";

    Thread t1 = new Thread("T1") {
        public void run() {
            while (true) {
                synchronized (str1) {
                    System.out.println("In T1");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    synchronized (str2) {
                        System.out.println(str1 + str2);
                    }

                }
            }
        }

    };

    Thread t2 = new Thread("T1") {
        public void run() {
            while (true) {
                synchronized (str2) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    synchronized (str1) {
                        System.out.println(str1 + str2);
                    }

                }
            }
        }

    };

    public static void main(String[] args) {
        MyDeadLock md = new MyDeadLock();
        System.out.println("Hi");
        md.t1.start();
        md.t2.start();

    }

}
