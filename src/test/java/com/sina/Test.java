package com.sina;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author zhangbin
 * @version 1.0, 2020-09-11
 * @since excel-test 1.0.0
 */
public class Test {

    private List<Integer> list = Collections.synchronizedList(new ArrayList<>());
    private static final String lock = "lock";

    class ThreadFirst extends Thread {

        @Override
        public void run() {
            int index = 1;
            while (true) {
                synchronized (lock) {
                    if (list.size() >= 3) {
                        try {
                            lock.notifyAll();
                            lock.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int i = new Random().nextInt(10);
                    list.add(i);
                    index++;
                }
            }
        }
    }


    class ThreadSecond extends Thread {

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (CollectionUtils.isEmpty(list)) {
                        try {
                            lock.notifyAll();
                            lock.wait();
                            System.out.println("本次结束");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    Integer remove = list.remove(0);
                    System.out.println(remove);

                }
            }
        }
    }

    public void run() {
        ThreadFirst threadFirst = new ThreadFirst();
        ThreadFirst threadFirst1 = new ThreadFirst();
        ThreadFirst threadFirst2 = new ThreadFirst();

        ThreadSecond threadSecond1 = new ThreadSecond();
        ThreadSecond threadSecond2 = new ThreadSecond();
        ThreadSecond threadSecond3 = new ThreadSecond();
        ThreadSecond threadSecond4 = new ThreadSecond();
        ThreadSecond threadSecond5 = new ThreadSecond();


        threadFirst.start();
        threadFirst1.start();
        threadFirst2.start();

        threadSecond1.start();
        threadSecond2.start();
        threadSecond3.start();
        threadSecond4.start();
        threadSecond5.start();
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.run();
    }
}
