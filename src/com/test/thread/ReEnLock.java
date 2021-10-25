package com.test.thread;

public class ReEnLock {
    private boolean isLocked = false;
    private int lockCount = 0;
    private Thread lockedBy = null;

    public synchronized void lock() throws InterruptedException {
        Thread callingThread = Thread.currentThread();
        while (isLocked && callingThread != lockedBy) {
            wait();
        }
        lockCount++;
        isLocked = true;
        lockedBy = callingThread;
    }

    public synchronized void unLock() {
        if (Thread.currentThread() == lockedBy)
            lockCount--;
        if (lockCount == 0) {
            isLocked = false;
            notifyAll();
        }

    }

}
