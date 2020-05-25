package com.lq.one;

/**
 * 自增变量
 * @author liqiao
 * 2020/5/26
 */
public class Day01 {
    public static void main(String[] args) {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i  * i++;
        System.out.println("i=" + i);
        System.out.println("j=" + j);
        System.out.println("k=" + k);

        // 结果 j =1， i=2,k = 2+ 3 * 3, i =4
    }
}
