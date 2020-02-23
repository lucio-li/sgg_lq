package com.lq;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Runnable {

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("come in");
        return 1024;
    }
}

/**
 * Created by liqiao on 2020/1/29.
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        Thread t1 = new Thread(futureTask, "AA");
        t1.start();
        int result = 100;
        int resultByThread = futureTask.get();// 建议放最后，会导致阻塞


        System.out.println("reult:" + (result + resultByThread));
    }
}
