package com.sina.算法.简单;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 977.
 * <p>
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-10-16
 * @since excel-test 1.0.0
 */
public class 有序数组的平方 {

    /**
     * 本人第一次，直接利用 Arrays.sort排序，完全没利用到该数组特性
     *
     * 执行用时 66.818%，2ms
     * 内存消耗 96.14%，40.2MB
     */
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    /**
     * 思路：找出正数和负数的交接点的两个 index，然后两个index比较绝对值的大小，填入新的数组，知否平方，返回
     *
     * @param a
     * @return
     */
    //public int[] sortedSquares1(int[] a) {
    //
    //}
}







