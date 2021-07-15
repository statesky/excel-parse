package com.sina.算法.面试;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * The xxx class for xxx.
 *
 * @author zhangbin
 * @version 1.0, 2021-06-07
 * @since excel-test 1.0.0
 */
public class 华为机师题1 {

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //
        //List<Integer> list = new ArrayList<>(100);
        //while (scanner.hasNext()) {
        //    list.add(scanner.nextInt());
        //}

        int[] ints = new int[]{7, 5, 9, 4, 2, 6, 8, 3, 5, 4, 3, 9};
        //A[] as = CollectionUtils.toArray(Integer.class, ints);


        //if (list.size() == 0) {
        //    System.out.println(0);
        //    return;
        //}
        //int size = list.size();
        //Map<Integer, Integer> map = new HashMap<>(100);
        //int index = 1;
        //for (int i = size - 2; i >= size / 2; i--) {
        //    if (list.get(i).equals(index)) {
        //
        //        map.put(index, 1);
        //    } else if (map.containsKey(index - list.get(i))) {
        //        Integer integer = map.get(i);
        //        map.put(index, integer + 1);
        //    }
        //}
        //if (map.isEmpty()) {
        //    for (int i = size / 2; i >= 0; i--) {
        //        if (list.get(i).equals(index)) {
        //            System.out.println(2);
        //            return;
        //        } else if (map.containsKey(index - list.get(i))) {
        //            Integer integer = map.get(i);
        //            System.out.println(integer + 2);
        //            return;
        //        }
        //    }
        //} else {
        //    Collection<Integer> values = map.values();
        //    Iterator<Integer> iterator = values.iterator();
        //    int min = 100;
        //    while (iterator.hasNext()) {
        //        if (iterator.next() < min) {
        //            min = iterator.next();
        //        }
        //    }
        //    System.out.println(min + 1);
        //}
    }


    public static void test(List<Integer> list) {
        if (list.size() == 0) {
            System.out.println(0);
            return;
        }
        int size = list.size();
        Map<Integer, Integer> map = new HashMap<>(100);
        int index = 1;
        for (int i = size - 2; i >= size / 2; i--) {
            if (list.get(i).equals(index)) {

                map.put(index, 1);
            } else if (map.containsKey(index - list.get(i))) {
                Integer integer = map.get(i);
                map.put(index, integer + 1);
            }
        }
        if (map.isEmpty()) {
            for (int i = size / 2; i >= 0; i--) {
                if (list.get(i).equals(index)) {
                    System.out.println(2);
                    return;
                } else if (map.containsKey(index - list.get(i))) {
                    Integer integer = map.get(i);
                    System.out.println(integer + 2);
                    return;
                }
            }
        } else {
            Collection<Integer> values = map.values();
            Iterator<Integer> iterator = values.iterator();
            int min = 100;
            while (iterator.hasNext()) {
                if (iterator.next() < min) {
                    min = iterator.next();
                }
            }
            System.out.println(min + 1);
        }
    }
}
