package com.sina.算法.简单;

/**
 * leetcode 283.
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-11-19
 * @since excel-test 1.0.0
 */
public class 移动零 {

    /**
     * 本人
     *
     * 执行用时 0ms     100.00%
     * 内存消耗 38.5MB  93.36%
     *
     * 思路：不想写
     */
    public int[] moveZeroes(int[] nums) {
        int index = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            if (index > i) {
                if (nums[i] == 0) {
                    index = i;
                }
            } else {
                if (nums[i] != 0) {
                    nums[index] = nums[i];
                    nums[i] = 0;
                    index++;
                }
            }
        }

        return nums;
    }
}
