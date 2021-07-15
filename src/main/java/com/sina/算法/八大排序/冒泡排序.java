package com.sina.算法.八大排序;

/**
 * The xxx class for xxx.
 *
 * @author zhangbin
 * @version 1.0, 2021-04-14
 * @since excel-test 1.0.0
 */
public class 冒泡排序 {

    public static int[] bubbleSorter(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return nums;
        }

        // 这是循环次数
        for (int i = 0; i < length - 1; i++) {
            boolean success = true;
            //	这是关键点，每次都从第一个开始，但后面i个已经排好了，所以不需要比较了
            for (int j = 0; j < length - i - 1; j++) {
                if (nums [j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    success = false;
                }
            }
            if (success) {
                break;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = SortUtils.createNums(100, 20);
        int[] ints = bubbleSorter(nums);
        System.out.println(SortUtils.toString(ints));
    }
}
