package com.lq;

import java.util.concurrent.*;

/**
 * Created by liqiao on 2020/2/3.
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(2, 5, 1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
//                try {
//                    TimeUnit.MICROSECONDS.sleep(2010);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    public static void threadPoolInit() {
        System.out.println(Runtime.getRuntime().availableProcessors());
//        ExecutorService threadPool = Executors.newFixedThreadPool(5); // 一池五个处理线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor(); // 一池1个处理线程
        ExecutorService threadPool = Executors.newCachedThreadPool(); // 一池N个处理线程

        // 模拟 10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try {
            for (int i = 0; i < 200; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
//                try {
//                    TimeUnit.MICROSECONDS.sleep(2010);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
