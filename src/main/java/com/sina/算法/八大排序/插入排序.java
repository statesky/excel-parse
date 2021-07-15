package com.sina.算法.八大排序;

import java.util.Arrays;

/**
 * @author zhangbin
 * @version 1.0, 2021-04-16
 * @since excel-test 1.0.0
 */
public class 插入排序 {

    public static void insertSort(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return;
        }
        // 依次向后遍历无序表，从1开始，因为第0个时有序表
        for (int i = 1; i < nums.length; i++) {
            // 这是需要加入有序表的第一个无序表字段
            int tmp = nums[i];
            // 有序表的最后一个
            int index = i - 1;
            // index 大于0保证在减的时候不会超出
            // tmp < nums[index] 表示该元素，需排在index元素的位置，而index元素应向后移动一位
            while (index >= 0 && tmp < nums[index]) {
                // index 向后移动一位
                nums[index + 1] = nums[index];
                // index-- 比较tmp元素是否需要继续前移
                index--;
            }
            // 加一的原因是因为上面减一了，将tmp赋值给index元素的位置，而原index元素已经向后移了
            nums[index + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{8, 9, 1, 7};
        int[] arr = SortUtils.createNums(100, 50);
        insertSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    //// 插入排序，原理略
    //public static void sort(int[] nums) {
    //
    //    if (nums.length <=1 ) {
    //        return;
    //    }
    //
    //    for (int i = 1; i < nums.length; i++) {
    //        int tmp = nums[i];
    //        int j = i - 1;
    //        while (j >= 0 && tmp < nums[j]) {
    //            nums[j + 1] = nums[j];
    //            j--;
    //        }
    //        nums[j + 1] = tmp;
    //    }
    //}
}
