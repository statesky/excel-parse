package com.sina.算法.中等;

import java.util.Arrays;

/**
 * leetcode 516.
 * <p>
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 * <p>
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 * <p>
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2021-06-10
 * @since excel-test 1.0.0
 */
public class 零钱兑换2 {

    /**
     * 本人
     * <p>
     * 没做出来，但有了大致思路，但感觉这种思路不太行
     * 有点像动态规划的算法，但表示不会
     */
    public int change(int amount, int[] coins) {
        int result = 0;
        int[] maxArr = new int[coins.length];
        int a;
        int b;
        Arrays.sort(coins);
        int sum = 0;
        int index = 0;
        // for (; index < coins.length; index++) {
        //     sum += coins[i];
        //     if (sum > amount) {
        //         index--;
        //         break;
        //     } else (sum == amount) {
        //         break;
        //     }
        // }
        // 等于零时不应继续计算，而应停止
        for (int i = 0; i <= index; i++) {
            a = amount / coins[i];
            b = amount % coins[i];
            if (b != 0) {
                maxArr[i] = a + 1;
            } else {
                maxArr[i] = a;
                result++;
            }
        }
        // 之后依次计算，想采用的递归的方式，从高位开始，高位从1开始，
        // amount - ncoins[i]，剩余的继续
        // 递归大致如下 function(coins, i, amount);
        // 最后一个判断是否等于0；等于0则result++返回，
        // 大于0继续，直到i == 0；返回
        // 小于0直接返回
        // 这样的话是可以实现的，但效率会很慢，通过剪枝也只能加快一点，
        return result;
    }

    /**
     * 来自官方
     * <p>
     * 执行用时 2ms     100%
     * 内存消耗 35.6MB  92.42%
     * <p>
     * 果真是动态规划，但是我看不懂，而且这也太简单了，我吐了
     *
     * @param amount
     * @param coins
     * @return
     */
    public int changeFromLeetCode(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        零钱兑换2 s = new 零钱兑换2();
        int[] arr = new int[]{1, 2, 5};
        int i = s.changeFromLeetCode(5, arr);
        System.out.println(i);
    }
}
