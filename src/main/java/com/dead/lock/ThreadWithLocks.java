package com.dead.lock;

import lombok.SneakyThrows;

public class ThreadWithLocks extends Thread {
    private final Object lock1;
    private final Object lock2;

    public ThreadWithLocks(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @SneakyThrows
    @Override
    public void run() {
       synchronized (lock1) {
           Thread.sleep(1_000);
           synchronized (lock2) {
               Thread.sleep(1_000);
           }
       }
    }
}
