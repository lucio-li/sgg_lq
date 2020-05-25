package com.lq.two;

import java.util.concurrent.CyclicBarrier;

/**
 * @author liqiao
 * 2020/1/20
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() ->{
            System.out.println("*******召唤神龙");
        });
        for (int i = 0; i < 7; i++) {
            final int tempId = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 收集到第：" + tempId + "龙珠");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, i + "").start();
        }
    }
}
