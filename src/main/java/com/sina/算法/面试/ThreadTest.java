package com.sina.算法.面试;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 内容
 * 4个生产者和5个消费者，生产者向队列中消费消息，当生产数量满了，通知消费者进行消费，消费者消费完了通知生产者进行生产
 * <p>
 * 这实际上是一个极简版的线程池功能
 *
 * @author zhangbin
 * @version 1.0, 2021-07-09
 * @since reward 1.0.0
 */
public class ThreadTest {

    // 当然也可以采用以下注释的list或者ConcurrentHashMap等去实现，但这些都没有使用BlockingQueue好，
    // 而BlockingQueue中最简单的就是ArrayBlockingQueue了，所以此处使用了ArrayBlockingQueue
    //List<Object> list =Collections.synchronizedList(new ArrayList<Object>);

    // 请一定要注意，notify，wait都是针对对象的，且只能配合synchronized使用，详情请百度这几个方法
    private ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

    // 使得可以打印不同的值，当然这个随意
    private static volatile Integer index = 0;

    // 定义一个对象方便方法中使用，因为以下针对对象的方法一定要是在同一对象中，故在此定义
    private static final String o = "lock";

    public void start() {
        Thread thread11 = new Thread(new ThreadFirst());
        Thread thread12 = new Thread(new ThreadFirst());
        Thread thread13 = new Thread(new ThreadFirst());
        Thread thread14 = new Thread(new ThreadFirst());
        Thread thread21 = new Thread(new ThreadSecond());
        Thread thread22 = new Thread(new ThreadSecond());
        Thread thread23 = new Thread(new ThreadSecond());
        Thread thread24 = new Thread(new ThreadSecond());
        Thread thread25 = new Thread(new ThreadSecond());
        thread11.setName("Thread-11");
        thread12.setName("Thread-12");
        thread13.setName("Thread-13");
        thread14.setName("Thread-14");
        thread21.setName("Thread-21");
        thread22.setName("Thread-22");
        thread23.setName("Thread-23");
        thread24.setName("Thread-24");
        thread25.setName("Thread-25");

        thread11.start();
        thread12.start();
        thread13.start();
        thread14.start();
        thread21.start();
        thread22.start();
        thread23.start();
        thread24.start();
        thread25.start();
    }

    class ThreadFirst implements Runnable {
        @Override
        public void run() {
            while (true) {
                // 先加锁
                synchronized (o) {
                    if (blockingQueue.size() >= 10) {
                        // 释放其余所有等待中线程
                        o.notifyAll();
                        try {
                            // 此线程等待，这样的话所有满足条件的线程皆会等待，哪怕经过了不断的释放，其实上面notify也是可以的
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("存入数据");
                        blockingQueue.offer(index);
                        index = index + 1;
                    }
                }
            }
        }
    }

    class ThreadSecond implements Runnable {

        @Override
        public void run() {
            while (true) {
                // 同上
                synchronized (o) {
                    if (blockingQueue.size() <= 0) {
                        o.notifyAll();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Integer peek = blockingQueue.poll();
                        System.out.println(Thread.currentThread().getName() + "-" + peek);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
    }
}
