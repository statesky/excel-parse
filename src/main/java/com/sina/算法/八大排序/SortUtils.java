package com.sina.算法.八大排序;

import java.util.Random;

/**
 * 排序工具类.
 *
 * @author zhangbin
 * @version 1.0, 2021-04-14
 * @since excel-test 1.0.0
 */
public class SortUtils {

    /**
     * 不包含重复数据
     */
    public static int[] createNums(int max, int num) {
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = new Random().nextInt(max);
        }
        return nums;
    }
    //
    ///**
    // * 包含重复数据
    // */
    //public static int[] createNumss(int max, int num) {
    //    int[] nums = new int[num];
    //    for (int i = 0; i < num; i++) {
    //        nums[i] = (int) (Math.random() * max);
    //    }
    //    return nums;
    //}

    public static String toString(int[] nums) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]).append(", ");
            if (i % 10 == 9 && i != nums.length - 1) {
                sb.append("\n");
            }
        }
        sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("]");
        return String.valueOf(sb);
    }

}
