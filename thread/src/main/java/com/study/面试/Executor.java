package com.study.面试;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 *
 * @author zhangbin
 * @version 1.0, 2021-05-25
 * @since excel-test 1.0.0
 */
public class Executor {

    private List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());

    ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(3);
    private static final String lock = "lock";

    class ThreadFirst extends Thread {

        @Override
        public void run() {
            int index = 1;
            while (true) {
                synchronized (lock) {
                    if (blockingQueue.size() >= 3) {
                        try {
                            lock.notifyAll();
                            lock.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int i = new Random().nextInt(10);
                    //list.add(i);
                    blockingQueue.offer(i);
                    System.out.println(Thread.currentThread().getName() + "放入元素：" + i);
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
                            //Thread.sleep(1000);
                            //Object o = new Object();
                            lock.notifyAll();
                            lock.wait();
                            //System.out.println("本次结束");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //Set<Map.Entry<String, Integer>> entries = list.entrySet();
                    //Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
                    //while (iterator.hasNext()) {
                    //    Map.Entry<String, Integer> next = iterator.next();
                    //    System.out.println(next.getValue());
                    //    iterator.remove();
                    //}

                    //Integer remove = list.remove(0);
                    //System.out.println(remove);
                    Integer peek = blockingQueue.poll();
                    System.out.println(peek);
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

        threadFirst.setName("threadFirst");
        threadFirst1.setName("threadFirst1");
        threadFirst2.setName("threadFirst2");
        threadSecond1.setName("threadSecond1");
        threadSecond2.setName("threadSecond2");
        threadSecond3.setName("threadSecond3");
        threadSecond4.setName("threadSecond4");
        threadSecond5.setName("threadSecond5");

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
        Executor test = new Executor();
        test.run();
    }
}
