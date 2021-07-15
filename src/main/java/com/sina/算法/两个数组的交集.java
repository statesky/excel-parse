package com.sina.算法;

import java.util.*;

/**
 * LeetCode350.
 *
 * @author zhangbin
 * @version 1.0, 2020-09-04
 * @since excel-test 1.0.0
 */
public class 两个数组的交集 {

    /**
     * 给定两个数组，编写一个函数来计算它们的交集
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     *
     * @param aList
     * @param bList
     * @return
     */
    public static int[] solution(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                Integer count = map.get(nums1[i]);
                count++;
                map.put(nums1[i], count);
            } else {
                map.put(nums1[i], 1);
            }
        }
        int length = nums1.length > nums2.length ? nums2.length : nums1.length;
        int[] c = new int[length];
        int j = 0;
        for (int i1 : nums2) {
            if (map.containsKey(i1)) {
                c[j] = i1;
                j++;
                Integer count = map.get(i1);
                count--;
                if (count <= 0) {
                    map.remove(i1);
                } else {
                    map.put(i1, count);
                }
            }
        }
        int[] d = new int[j];
        System.arraycopy(c, 0, d, 0, j);
        return d;
    }

    /**
     * 进阶:
     * 如果给定的数组已经排好序呢？将如何优化你的算法呢？
     *
     * @param aList
     * @param bList
     * @return
     */
    public static Integer[] solution2(List<Integer> aList, List<Integer> bList) {
        Integer[] arrayA = new Integer[aList.size()];
        arrayA = aList.toArray(arrayA);
        Integer[] arrayB = new Integer[bList.size()];
        arrayB = bList.toArray(arrayB);
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int length = arrayA.length > arrayB.length ? arrayB.length : arrayA.length;
        Integer[] c = new Integer[length];

        int a = 0, b = 0, d = 0;
        while (a < arrayA.length && b < arrayB.length) {
            if (arrayA[a].equals(arrayB[b])) {
                // 此行必须在此处，否则就不是实际的那个了
                c[d] = arrayA[a];
                d++;
                a++;
                b++;
            } else if (arrayA[a] > arrayB[b]) {
                b++;
            } else {
                a++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int[] a = new int[4];
        int[] b = new int[4];
        a[0] = 1;
        a[1] = 2;
        a[2] = 2;
        a[3] = 4;

        b[0] = 1;
        b[1] = 2;
        b[2] = 5;
        b[3] = 2;
        int[] solution = solution(a, b);
        //Integer[] integers = solution2(aList, bList);
        int a1 = 110;
        int i1 = a1 % 10;
        System.out.println(a);
        int i = (int) Math.log10(a1) + 1;

        System.out.println(Arrays.toString(solution));
        //System.out.println(integers);
    }
}
