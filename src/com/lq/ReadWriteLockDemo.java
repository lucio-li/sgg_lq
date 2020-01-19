package com.lq;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author liqiao
 * 2020/1/19
 */
public class ReadWriteLockDemo {
    private volatile Map<String, Object> map = new HashMap<>();

    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
        try {
            TimeUnit.MICROSECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "\t 写入完成");

    }
}
