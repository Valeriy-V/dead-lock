package com.dead.lock;

import lombok.SneakyThrows;

public class DemoApp {
    @SneakyThrows
    public static void main(String[] args) {
        Object monitor1 = new Object();
        Object monitor2 = new Object();

        Thread thread1 = new ThreadWithLocks(monitor1, monitor2);
        thread1.setName("FIRST");

        Thread thread2 = new ThreadWithLocks(monitor2, monitor1);
        thread2.setName("SECOND");

        System.out.println("-: " + thread1.getName() + " " + thread1.getState());
        System.out.println("-: " + thread2.getName() + " " + thread2.getState());

        thread1.start();
        thread2.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + thread1.getName() + " " + thread1.getState());
            System.out.println(i + ": " + thread2.getName() + " " + thread2.getState());
            Thread.sleep(500);
        }
    }
}
