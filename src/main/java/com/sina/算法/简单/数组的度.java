package com.sina.算法.简单;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 697.
 * <p>
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2：
 * <p>
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 * <p>
 * 提示：
 * <p>
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2021-02-20
 * @since excel-test 1.0.0
 */
public class 数组的度 {

    public int findShortestSubArray(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }
        for (int i = 0; i < length; i++) {
            nums[i] = nums[i] * 100000 + i;
        }
        Arrays.sort(nums);
        int result = 0;
        int resultSum = 0;
        int sum = 1;
        int begin = nums[0] % 100000;
        int end = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] / 100000 == nums[i - 1] / 100000) {
                sum = sum + 1;
                end = nums[i] % 100000;
            } else {
                //end = nums[i - 1] % 100000;
                if (sum > result) {
                    result = sum;
                    resultSum = end - begin + 1;
                } else if (sum == result) {
                    int resultSum1 = end - begin - 1;
                    resultSum = resultSum > resultSum1 ? resultSum : resultSum1;
                }
                begin = nums[i] % 100000;
                end = begin;
            }
        }

        if (sum > result) {
            resultSum = end - begin + 1;
            result = sum;
        } else if (sum == result) {
            int resultSum1 = end - begin - 1;
            resultSum = resultSum > resultSum1 ? resultSum : resultSum1;
        }

        return resultSum;
    }

    /**
     * 来自官方
     *
     *
     *
     * @param nums
     * @return
     */
    public int findShortestSubArray1(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (maxNum < arr[0]) {
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (maxNum == arr[0]) {
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        数组的度 s = new 数组的度();
        int[] nums = new int[]{1, 1};
        int sum = s.findShortestSubArray(nums);
        System.out.println(sum);
    }
}
