package com.study;

/**
 * .
 *
 * @author zhangbin
 * @version 1.0, 2021-04-28
 * @since excel-test 1.0.0
 */
public class Aaa {

    private static String aa = "";
    private static volatile int a = 0;


    public void run() {
        ThreadFirst threadFirst = new ThreadFirst();
        threadFirst.setName("hahah");
        threadFirst.start();
        ThreadSecond threadSecond = new ThreadSecond();
        threadSecond.setName("aaa");
        threadSecond.start();

    }

    class ThreadFirst extends Thread {

        @Override
        public void run() {
            while (a <= 100) {
                if (a % 2 == 0) {
                    synchronized (this) {
                        if (a <= 100) {
                            System.out.println(Thread.currentThread().getName() + a);
                            a++;
                        }
                    }
                }
            }
        }
    }


    class ThreadSecond extends Thread {
        @Override
        public void run() {
            while (a <= 100) {
                if (a % 2 == 1) {
                    synchronized (this) {
                        if (a <= 100) {
                            System.out.println(Thread.currentThread().getName() + a);
                            a++;
                        }

                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Aaa aaa = new Aaa();
        aaa.run();
    }


}
