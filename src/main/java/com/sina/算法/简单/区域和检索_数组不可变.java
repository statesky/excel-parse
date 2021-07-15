package com.sina.算法.简单;

/**
 * leetcode 303.
 * <p>
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 * <p>
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 * <p>
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= i <= j < nums.length
 * 最多调用 104 次 sumRange 方法
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2021-03-01
 * @since excel-test 1.0.0
 */
public class 区域和检索_数组不可变 {
    private int[] nums;

    /**
     * 本人
     *
     * @param nums
     */
    public 区域和检索_数组不可变(int[] nums) {
        this.nums = nums;
    }
 //public 区域和检索_数组不可变(int[] nums) {
    //    this.nums = nums;
    //}

    /**
     * 本人
     *
     * 执行用时 80ms    16.17%
     * 内存消耗 41.6MB  9.98%
     *
     * 没想到这么慢，呜呜呜呜呜
     *
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int i, int j) {
        int sum = 0;
        for (; i <= j; i++) {
            sum = +nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};

        区域和检索_数组不可变 numArray = new 区域和检索_数组不可变(nums);
        int i = numArray.sumRange(0, 2);
        int i1 = numArray.sumRange(2, 5);
        int i2 = numArray.sumRange(0, 5);
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);
    }
}
