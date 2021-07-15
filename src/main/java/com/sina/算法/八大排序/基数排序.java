package com.sina.算法.八大排序;

import java.util.Arrays;

/**
 * @author zhangbin
 * @version 1.0, 2021-04-19
 * @since excel-test 1.0.0
 */
public class 基数排序 {

    /**
     * 主要思路：
     * <p>
     * 首先，找出最大的那个值，由此知道最大的位数
     * 循环位数次
     * 第一次，
     * * 拿到个位的值，将它放入该数字桶，并在另一数组中记录下一个未填的位数，下一次时放入该位数内，直至数组全部放入桶中
     * * 之后从第一个开始依次取出桶中的值，取完之后将另一数组对应桶计数重置为0，以便下次使用
     * 之后重复上述步骤，循环完 最大的位数次后结束，此时，数组已排序完成
     * <p>
     * 经典的牺牲空间换取时间的算法
     */
    public static void radixSort(int[] arr) {
        int length = arr.length;
        // 若小于等于1，不需要排序，直接返回
        if (length <= 1) {
            return;
        }
        // 定义桶
        int[][] bucket = new int[10][length];
        // 定义桶计数数组
        int[] nums = new int[bucket.length];
        // 找出最大值
        int tmp = arr[0];
        for (int i = 1; i < length; i++) {
            if (tmp < arr[i]) {
                tmp = arr[i];
            }
        }
        // 得到位数
        int x = 0;
        while ((tmp = tmp / 10) > 0) {
            x++;
        }
        int s = 10;
        // 开始遍历
        for (int i = 0; i <= x; i++) {
            for (int i1 : arr) {
                // 该位数的值
                int a = i1 % s / (s / 10);
                // set进入桶
                bucket[a][nums[a]] = i1;
                // 计数++
                nums[a]++;
            }
            s = 10 * 10;
            // 开始拿到桶中值
            int index = 0;
            // 遍历所有桶
            for (int k = 0; k < bucket.length; k++) {
                // 判断是否需要从该桶获取数据
                if (nums[k] != 0) {
                    // 拿到数据
                    for (int y = 0; y < nums[k]; y++) {
                        arr[index++] = bucket[k][y];
                    }
                    // 重置桶计数
                    nums[k] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        //int[] arr = new int[]{2, 3, 1, 4, 5, 9, 6,};
        int[] arr = SortUtils.createNums(100, 20);
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
