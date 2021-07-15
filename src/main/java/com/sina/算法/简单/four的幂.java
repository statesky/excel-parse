package com.sina.算法.简单;

/**
 * leetcode 342.
 * <p>
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 16
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2021-05-31
 * @since excel-test 1.0.0
 */
public class four的幂 {

    /**
     * 本人
     * 执行用时 1ms     100%
     * 内存消耗 35.2MB  97.01%
     */
    public boolean isPowerOfFour(int n) {
        // 需判断是否为0
        if (n == 0) {
            return false;
        }
        while (n != 1 && n % 4 == 0) {
            n = n / 4;
        }

        return n == 1;
    }


    public static void main(String[] args) {

    }
}
