package com.sina.算法.简单;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 1207.
 * <p>
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * <p>
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-number-of-occurrences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-10-28
 * @since excel-test 1.0.0
 */
public class 独一无二的出现次数 {

    /**
     * 本人
     * <p>
     * 执行用时 2ms     91.43%
     * 内存消耗 36.4MB  90.03%
     *
     * 过程很简单，先得出次数，再查询是否重复
     * 官网也是这种解法，不愧是简单
     */
    private boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                Integer count = map.get(i) + 1;
                map.put(i, count);
            } else {
                map.put(i, 1);
            }
        }
        List<Integer> list = new ArrayList<>(map.values());
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (Integer i : list) {
            if (hashMap.containsKey(i)) {
                return false;
            } else {
                hashMap.put(i, 0);
            }
        }

        return true;

    }

    public static void main(String[] args) {
        独一无二的出现次数 s = new 独一无二的出现次数();
        int[] arr = new int[]{1, 2};
        boolean b = s.uniqueOccurrences(arr);
    }
}
