package com.sina.算法.未完成;

/**
 * Leetcode 60.
 *
 * @author zhangbin
 * @version 1.0, 2020-09-05
 * @since excel-test 1.0.0
 */
public class 第k个排列 {

    // TODO 未完成
    public static String getPermutation(int n, int k) {
        int a = 0;
        int b = 0;
        for (int i = 1; i < n; i++) {
            k = k / i;
            if (k == 1) {
                a = i;
                b = 0;
                break;
            } else if (k <= i + 1) {
                a = i + 1;
                b = k;
                break;
            }
        }
        if (a == 0) {
            return "该组合没有这么多的个数";
        }


        return "";

    }

    public static void main(String[] args) {
        String permutation = getPermutation(3, 3);
        System.out.println(permutation);
    }
}
