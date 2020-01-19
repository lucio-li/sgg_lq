package com.lq;

/**
 * @author liqiao
 * 2020/1/19
 */
class Phone {
    public synchronized void sendSMS() {
        System.out.println(Thread.currentThread().getName() + "   sendSMS");
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendEmail();
    }
    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + " start======  sendsendEmail");
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end======  sendsendEmail");
    }
}
public class ReentranLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendSMS();
        }, "t1").start();
        new Thread(() -> {
            phone.sendEmail();
        }, "t2").start();


    }
}
