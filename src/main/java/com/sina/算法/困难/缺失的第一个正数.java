package com.sina.算法.困难;

import java.util.Arrays;

/**
 * leetcode 41.
 * <p>
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-10-28
 * @since excel-test 1.0.0
 */
public class 缺失的第一个正数 {

    /**
     * 本人
     * <p>
     * 执行用时 1ms     86.52%
     * 内存消耗 36.2MB  90.21%
     * <p>
     * 使用count递增来找到下一个整数，简单
     * <p>
     * 在排序的时候可以适当优化，但抱歉，我不会
     */
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int num = nums[i];
            if (num <= 0) {
                continue;
            }
            if (num == count) {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }

    /**
     * 来自官网，很巧妙
     *
     * 执行用时 1ms     86.52%
     * 内存消耗 35.9MB  97.06%
     */
    public int firstMissingPositiveFromLeetCode(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        缺失的第一个正数 s = new 缺失的第一个正数();
        int[] nums = new int[]{0, 2, 2, 1, 1};
        int i = s.firstMissingPositive(nums);
        System.out.println(i);
    }
}

//[0,2,2,1,1]
