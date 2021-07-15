package com.study.线程实现方式;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 通过 Callable 和 FutureTask 创建.
 *
 * @author zhangbin
 * @version 1.0, 2021-04-28
 * @since excel-test 1.0.0
 */
public class FutureTaskDemo {

    public static void main(String[] args) {
        CallableDemo callableDemo = new CallableDemo();

        FutureTask<String> futureTask = new FutureTask<String>(callableDemo);
        // 这样才会启动这个线程
        new Thread(futureTask).start();

        try {
            // 用于接收结果进行操作
            String s = futureTask.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        List<Integer> objects = Collections.synchronizedList(new ArrayList<Integer>());
    }


}

class CallableDemo implements Callable<String> {

    public String call() throws Exception {
        return "哈哈哈";
    }
}

