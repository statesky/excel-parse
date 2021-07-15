package com.study.线程实现方式;

/**
 * 实现 Runnable 接口.
 *
 * @author zhangbin
 * @version 1.0, 2021-04-28
 * @since excel-test 1.0.0
 */
public class ImplementRunnable implements Runnable {

    public void run() {
        System.out.println("哈哈哈哈");
    }

    public static void main(String[] args) {
        ImplementRunnable runnable = new ImplementRunnable();

        Thread thread = new Thread(runnable);

        thread.start();
    }
}
