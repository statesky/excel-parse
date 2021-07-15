package com.sina;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * The xxx class for xxx.
 *
 * @author zhangbin
 * @version 1.0, 2020-04-07
 * @since excel-test 1.0.0
 */
public class MainClass {

    public static void main(String[] args) {
        Stream<String> stringStream = IntStream.rangeClosed(1, 3).mapToObj(i -> "item" + ThreadLocalRandom.current().nextInt());
    }
}
