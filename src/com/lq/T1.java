package com.lq;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liqiao
 * 2020/1/18
 */
public class T1 {
    volatile int n = 0;
    public void add() {
        n++;
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
    }
}
