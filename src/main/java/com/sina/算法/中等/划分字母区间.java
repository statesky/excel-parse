package com.sina.算法.中等;

import java.util.*;

/**
 * leetcode 763.
 * <p>
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-10-22
 * @since excel-test 1.0.0
 */
public class 划分字母区间 {

    /**
     * 本人
     * <p>
     * 本算法有一个致命缺陷，无法确定当前位置值是否在前面错在
     * 现在更新后还是有这个问题，从后往前出现不重复的就会少一个，在不重复的最开始会出现重复的下标
     *
     * 此问题未解决，此方法太麻烦了，
     *
     * @param S
     * @return
     */
    public static List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (map.containsKey(c)) {
                Integer index = map.get(c);
                Integer pop = stack.peek();
                while (index < pop) {
                    stack.pop();
                    pop = stack.peek();
                }
                stack.push(i + 1);
            } else {
                map.put(c, i);
                stack.push(i);
            }
        }
        stack.empty();

        Integer pre = stack.pop();
        List<Integer> list = new ArrayList<>();
        //if (pre == S.length()) {
        //    list.add(1);
        //}
        Integer pop = stack.peek();
        if (pre.equals(pop)) {
            list.add(1);
        }
        while (!stack.empty()) {
            pop = stack.pop();
            if (!pre.equals(pop)) {
                list.add(0, pre - pop);
                pre = pop;
            }
        }
        return list;
    }

    /**
     * 来自leetcode官网
     *
     * 采用贪心+双指针算法
     *
     * 执行用时 3ms     96.88%
     * 内存消耗 36.8MB  97.62%
     *
     */
    public static List<Integer> partitionLabelsFromLeetCode(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

    public static void main(String[] args) {

        String s = "qvmwtmzzse";
        //List<Integer> list = partitionLabels(s);

        List<Integer> list1 = partitionLabelsFromLeetCode(s);

        System.out.println(list1.toString());
    }
}

//"ababcbacadefegdehijhklij"

// "eaaaabaaec"

//"qvmwtmzzse"
