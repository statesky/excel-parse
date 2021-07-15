package com.sina.算法.面试;

/**
 * 来自阿里一面面试题.
 * <p>
 * 有很多时间片段，如起始时刻a到结束时刻b，表示为(a, b)，求所有时间片段的覆盖时间区间，如(1, 4), (2, 5), (8,9)的覆盖时间区间为(1,5)(8,9)
 *
 * 和插入区间类似
 *
 * @author zhangbin
 * @version 1.0, 2021-04-26
 * @since excel-test 1.0.0
 */
public class 重复时间片 {

    public static int[][] soer(int[][] sums) {
        int[][] result = new int[sums.length][2];
        if (sums.length <= 1) {
            return sums;
        }


        for (int i = 0; i < sums.length; i++) {

        }


        return result;
    }
}
