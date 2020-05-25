package com.lq.two;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liqiao
 * 2020/1/18
 */


class User{
    String userName;
    int age;
    User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }


    @Override
    public String toString() {
        return "name:" + this.userName + ", age:" + this.age;
    }
}
public class AtomicReferenceDemo {
    public static void main(String[] args) {

        User zs = new User("z3", 22);
        User li4 = new User("li4", 25);
        User li5 = new User("li5", 27);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(zs);
        System.out.println(atomicReference.compareAndSet(zs, li4));
        System.out.println(atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(zs, li5));
        System.out.println(atomicReference.get().toString());
    }
}
