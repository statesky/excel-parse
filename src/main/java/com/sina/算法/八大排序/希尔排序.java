package com.sina.算法.八大排序;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * 希尔排序.
 *
 * @author zhangbin
 * @version 1.0, 2020-11-18
 * @since excel-test 1.0.0
 */
public class 希尔排序 {

    public static void shellSort1(int[] nums) {
        int tmp = 0;
        // gap 为步长，直至为1时为最后一轮
        for (int gap = nums.length / 2; gap > 0; gap = gap / 2) {
            // 此时相当于位于第二轮步长第一个的位置，所以是 i++
            // 这很巧妙，正好略过了第一个值
            // 从这以下的整个循环，大致意思就是相当于插入排序的思想
            // 第一个值已经排好，所以从第二个值开始，每次一个新的值进来
            // 都将其放在应该放的位置直至i平移到最后一位，排序完成
            for (int i = gap; i < nums.length; i++) {
                // 这里没看仔细的话是个大坑
                for (int j = i - gap; j >= 0; j = j - gap) {
                    if (nums[j] > nums[j + gap]) {
                        tmp = nums[j];
                        nums[j] = nums[j + gap];
                        nums[j + gap] = tmp;
                    }
                }
            }
        }
    }

    /**
     * 交换法希尔算法
     */
    public static int[] shellSort(int[] arr) {
        int tmp;
        // gap 为步长，直至为1时为最后一轮
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 此时相当于位于第二轮步长第一个的位置，所以是 i++
            // 从这以下的整个循环，大致意思就是相当于插入排序的思想
            // 第一个值已经排好，所以从第二个值开始，每次一个新的值进来
            // 都将其放在应该放的位置直至i平移到最后一位，排序完成
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        tmp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = tmp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    /**
     * 移动法希尔算法
     * 相比于交换法速率大大加快
     */
    public static void shellSort2(int[] nums) {
        // 增量 gap，并逐步缩小增量
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < nums.length; i++) {
                int j = i;
                int tmp = nums[j];
                //if (nums[j] < nums[i - gap]) {
                    while (j - gap >= 0 && tmp < nums[j - gap]) {
                        // 移动
                        nums[j] = nums[j - gap];
                        j -= gap;
                    }
                    // 当退出while后，就给tmp找到插入的位置
                    nums[j] = tmp;
                }
            }
        //}
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        //shellSort2(arr);

        //System.out.println(Arrays.toString(arr));

        BigDecimal a = new BigDecimal("2");
        int i = a.intValue();
        System.out.println(i);
    }
}
