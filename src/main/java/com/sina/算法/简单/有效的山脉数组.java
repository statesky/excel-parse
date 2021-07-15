package com.sina.算法.简单;

/**
 * leetcode 941.
 * <p>
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * <p>
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * <p>
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-11-03
 * @since excel-test 1.0.0
 */
public class 有效的山脉数组 {

    /**
     * 本人，一定要注意边界问题，不然会有问题
     * <p>
     * 执行用时 1ms     100.00%
     * 内存消耗 39.3MB  95.05%
     *
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        int i = 0;

        if (A[i] >= A[i + 1]) {
            return false;
        } else {
            while (A[i] < A[i + 1]) {
                i++;
                if (i >= A.length - 1) {
                    return false;
                }
            }
            while (A[i] > A[i + 1]) {
                i++;
                if (i >= A.length - 1) {
                    return true;
                }
            }
            return false;
        }

    }

    public static void main(String[] args) {
        有效的山脉数组 s = new 有效的山脉数组();
        int[] a = new int[]{};
        boolean b = s.validMountainArray(a);
        System.out.println(b);
    }
}

// [0,3,2,1]
