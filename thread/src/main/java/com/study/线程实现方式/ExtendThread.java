package com.study.线程实现方式;

/**
 * 继承 Thread 抽象类.
 *
 * @author zhangbin
 * @version 1.0, 2021-04-28
 * @since excel-test 1.0.0
 */
public class ExtendThread extends Thread{

    @Override
    public void run() {
        System.out.println("哈哈哈哈");
    }

    public static void main(String[] args) {
        ExtendThread thread = new ExtendThread();

        thread.setName("线程一");
        thread.start();
    }
}
