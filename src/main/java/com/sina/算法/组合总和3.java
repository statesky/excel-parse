package com.sina.算法;

import java.util.*;

/**
 * leetcode 216.
 * <p>
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-09-11
 * @since excel-test 1.0.0
 */
public class 组合总和3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> lsit = new HashSet<>();
        dfs(k, n, 1, list, new ArrayList<>());
        return list;
    }

    private void dfs(int k, int n, int indwx, List<List<Integer>> list, List<Integer> s) {
        if (s.size() > k || n < 0) {
            return;
        }
        if (s.size() == k && n == 0) {
            //Integer[] a = new Integer[s.size()];
            //s.toArray(a);
            //Arrays.sort(a);
            list.add(new ArrayList<>(s));
        }
        if (s.size() < k && n > 0) {
            for (int i = indwx; i <= 9; i++) {
                s.add(i);
                dfs(k, n - i, i + 1, list, s);
                s.remove(s.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new 组合总和3().combinationSum3(3, 7);
        System.out.println(lists);
    }
}
