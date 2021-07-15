package com.sina;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The xxx class for xxx.
 *
 * @author zhangbin
 * @version 1.0, 2020-05-29
 * @since excel-test 1.0.0
 */
public class STest {

    @Test
    public void string() {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("a");
        strings.add("a");
        strings.add("a");

        String[] strings1 = strings.toArray(new String[0]);

        boolean a = strings.removeIf(s -> s.equals("a"));
    }

    @Test
    public void intTest() {
        int[] is = new int[0];
        for (int i = 0; i < 3; i++) {
            is[i] = 1;
        }
    }

    @Test
    public void toEpochDay() {
        LocalDate end = LocalDate.of(2017, 1, 27);
        LocalDate begin = LocalDate.of(2016, 8, 9);
        long l = end.toEpochDay();
        long l1 = begin.toEpochDay();
        long l2 = l - l1;
        System.out.println(l2);
    }

    @Test
    public void asList() {
        int a = 10;
        int b = 4;
        int i = a % b;
        int i1 = a / b;
        String[] str = new String[]{"yang", "hao"};

        String[] strs = {"dog", "cat", "cow"};
        List<String> listB = Arrays.asList(strs);
        List list = Arrays.asList(str);
        //list.add("ss");
        System.out.println(list);
        str[1] = "sss";
        System.out.println(list);

    }

    @Test
    public void queue() {
        ArrayDeque<Integer> integers = new ArrayDeque<>();
        integers.addFirst(3);
        integers.addLast(4);
        integers.add(1);
        integers.add(2);

    }

    @Test
    public void toLocalDateTime() {
        LocalDateTime begin = toTime(1600794000000L);
        LocalDateTime end = toTime(1600707600000L);

        System.out.println(begin);
        System.out.println(end);
    }


    public LocalDateTime toTime(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    @Test
    public void concurrent() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(100);
        map.put("s", "张三");
        map.put("w", "李四");
        map.put("a", "王五");
        map.put("b", "王五");
        map.put("c", "王五");
        map.put("d", "王五");
        map.put("e", "王五");
        map.put("f", "王五");
        map.put("g", "王五");
        map.put("h", "王五");
        map.put("i", "王五");
        map.put("j", "王五");
        map.put("k", "王五");
        map.put("l", "王五");
        map.put("m", "王五");
        map.put("n", "王五");
        map.put("as", "王五");
        map.put("ad", "王五");
        map.remove("s");
    }

    @Test
    public void aa() {
        double v = (1119.00 - 1071.08) * 8;
        System.out.println(
                v
        );
    }
}








