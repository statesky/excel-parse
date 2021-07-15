package com.sina.算法.面试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * The xxx class for xxx.
 *
 * @author zhangbin
 * @version 1.0, 2021-06-07
 * @since excel-test 1.0.0
 */
public class 华为机试题2 {

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //int a, c;
        //List<Integer> list = new ArrayList<>();
        //if (sc.hasNext()) {
        //    a = sc.nextInt();
        //} else {
        //    System.out.println(0);
        //    return;
        //}
        //
        //while (sc.hasNext()) {
        //    list.add(sc.nextInt());
        //}
        //if (list.size() <= 1) {
        //    System.out.println(0);
        //    return;
        //}

        //c = list.remove(list.size() - 1);
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(1);
        list1.add(5);
        list1.add(7);
        list1.add(9);
        //list1.add(3);
        test(5, list1, 8);
        //Integer[] arr = new Integer[list.size()];
        //list.toArray(arr);
        //Arrays.sort(arr);
        //int i = 0;
        //
        //while (i < list.size() && arr[i] < c) {
        //    i++;
        //}
        //int result = 0;
        //if (arr[i] < c) {
        //    int k = 0;
        //    for (int j = list.size() - 1; j >= 0; j--) {
        //        for (; k < j; k++) {
        //            if (arr[j] + arr[k] >= c) {
        //                result = result + j - k;
        //                break;
        //            }
        //        }
        //    }
        //} else if (i == 0) {
        //    //int result = 0;
        //    for (int j = 0; j < list.size() - 1; j++) {
        //        result = result + j + 1;
        //    }
        //} else {
        //    int k = 0;
        //    for (int j = i - 1; j >= 0; j--) {
        //        for (; k < j; k++) {
        //            if (arr[j] + arr[k] >= c) {
        //                result = result + j - k;
        //                break;
        //            }
        //        }
        //    }
        //    for (int j = i; j < list.size() - 1; j++) {
        //        result = result + j + 1;
        //    }
        //}
        //System.out.println(result);
    }

    public static void test(int a, List<Integer> list, int c) {
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
        Arrays.sort(arr);
        int i = 0;

        while (i < list.size() && arr[i] < c) {
            i++;
        }
        int result = 0;
        if (arr[i] < c) {
            int k = 0;
            for (int j = list.size() - 1; j >= 0; j--) {
                for (; k < j; k++) {
                    if (arr[j] + arr[k] >= c) {
                        result = result + j - k;
                        break;
                    }
                }
            }
        } else if (i == 0) {
            //int result = 0;
            for (int j = 0; j < list.size() - 1; j++) {
                result = result + j + 1;
            }
        } else {
            int k = 0;
            for (int j = i - 1; j >= 0; j--) {
                for (; k < j; k++) {
                    if (arr[j] + arr[k] >= c) {
                        result = result + j - k;
                        break;
                    }
                }
            }
            for (int j = i; j < list.size() - 1; j++) {
                result = result + j + 1;
            }
        }
        System.out.println(result);
    }
}
