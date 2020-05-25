package com.lq.two;

import java.util.concurrent.CountDownLatch;

/**
 * @author liqiao
 * 2020/1/20
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        try {
            cloaeDoor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void cloaeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "  上完自习， 离开教室");
                countDownLatch.countDown();
            }, i + "").start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t *****************班长最后关门走人");

    }
}
