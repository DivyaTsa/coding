package com.test.thread;

public class RWLock {
    private boolean isLocked = false;
    private int writeLocks = 0;
    private int readLocks = 0;
    private int writeRequests = 0;

    public synchronized void readLock() throws InterruptedException {
        while (writeLocks > 0 || writeRequests > 0)
            wait();

        readLocks++;

    }

    public synchronized void unlockRead() {
        readLocks--;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        writeRequests++;
        while (writeLocks > 0 || readLocks > 0)
            wait();
        writeRequests--;
        writeLocks++;

    }

    public synchronized void unlockWrite() {
        writeLocks--;
        notifyAll();
    }

}
