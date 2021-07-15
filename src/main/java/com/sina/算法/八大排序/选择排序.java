package com.sina.算法.八大排序;

/**
 * @author zhangbin
 * @version 1.0, 2021-04-14
 * @since excel-test 1.0.0
 */
public class 选择排序 {

    public static void selectSort(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[index] > nums[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = SortUtils.createNums(10, 5);
        System.out.println(SortUtils.toString(nums));
        selectSort(nums);
        System.out.println(SortUtils.toString(nums));
    }
}
