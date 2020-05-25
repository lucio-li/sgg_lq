package com.lq.two;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() {
        try {
            lock.lock();
            // 1. 判断
            while (number != 0) { //不能用if, await方法可能会被唤醒的，被其他线程
                // 等待
                condition.await();
            }
            // 2. 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void decrement() {
        try {
            lock.lock();
            // 1. 判断
            while (number <= 0) { //不能用if, await方法可能会被唤醒的，被其他线程
                // 等待
                condition.await();
            }
            // 2. 干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
/**
 * @author liqiao
 * 2020/1/21
 * 题目：一个初始值为零的变量，两个线程对其交替操作，一个加1一个减1， 来5轮
 * 1 线程 操作  资源类
 */
public class ProdConsumer_traditionDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.increment();
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.decrement();
            }
        }, "BB").start();
    }

}
