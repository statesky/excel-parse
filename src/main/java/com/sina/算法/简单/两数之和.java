package com.sina.算法.简单;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1.
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-10-27
 * @since excel-test 1.0.0
 */
public class 两数之和 {


    /**
     * 本人，本来想排序后在进行的，结果发现不行，这样的话返回的index就不对了
     * 所以就这样了，这是最简单的暴力破解法，极其的low，如果自己排序的话可以用二维数组把原index记录下来
     * <p>
     * 执行用时 65ms    37.65%
     * 内存消耗 38.1MB  98.95
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    results[0] = i;
                    results[1] = j;
                    return results;
                }
            }
        }
        return results;
    }

    /**
     * 来自官方
     * <p>
     * 这思路是我没想到的，66666
     * <p>
     * 执行用时 3ms     73.72%
     * 内存消耗 38.5MB  92.98%
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumFromLeetCode(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

}
