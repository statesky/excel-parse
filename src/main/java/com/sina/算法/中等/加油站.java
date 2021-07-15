package com.sina.算法.中等;

/**
 * leetcode 134.
 * <p>
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * <p>
 * 说明: 
 * <p>
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * 示例 1:
 * <p>
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * <p>
 * 输出: 3
 * <p>
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 * <p>
 * 输入:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * <p>
 * 输出: -1
 * <p>
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gas-station
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-11-18
 * @since excel-test 1.0.0
 */
public class 加油站 {

    /**
     * 本人
     *
     * 执行用时 0ms     100.00%
     * 内存消耗 38.6MB  90.93%
     *
     * 思路： 先合并，之后从0作为起点开始运行，当过程中油为负数时，表明此至起点之间都不能作为起点，从下一个开始，直至结束
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        for (int i = 0; i < length; ++i) {
            gas[i] = gas[i] - cost[i];
        }

        int begin = 0;

        while (begin < length) {
            int sum = 0;
            int index = begin;
            while (sum >= 0) {
                sum = sum + gas[index];
                index++;
                if (index == length) {
                    index = 0;
                }
                // 此时已遍历完成
                if (index == begin) {
                    if (sum >= 0) {
                        return begin;
                    } else {
                        return -1;
                    }
                }
            }
            if (index < begin) {
                return -1;
            }
            begin = index;
        }
        return -1;
    }

    public static void main(String[] args) {
        加油站 s = new 加油站();
        int[] a = new int[]{1,2,3,4,3,2,4,1,5,3,2,4};
        int[] b = new int[]{1,1,1,3,2,4,3,6,7,4,3,1};
        int i = s.canCompleteCircuit(a, b);
        System.out.println(i);
    }
}

//[1,2,3,4,3,2,4,1,5,3,2,4]
//[1,1,1,3,2,4,3,6,7,4,3,1]
