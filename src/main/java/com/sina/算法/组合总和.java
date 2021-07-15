package com.sina.算法;

import java.util.*;

/**
 * leetCode 39.
 * <p>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-09-09
 * @since excel-test 1.0.0
 */
public class 组合总和 {

    private static int[] a;
    private static int max;
    private static List<List<Integer>> list = new ArrayList<>();
    private static List<Integer> s = new ArrayList<>();

    /**
     * 第一次采用累加的方式，但除了前几次正确，后面有些就不正确了，然后直接被我删了
     * 在第一次看题解之后采用了累减的思路，写出来的代码整体尚可，但在删除 s 的无用add上碰到了问题
     * 之后参考题解进行了改良，完成了如下代码，和题解神似，花了我一下午的时间，特别是第一种，还学习了皇后算法，简直惨不忍睹
     * 看了下面的解题思路，
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        a = candidates;
        max = a.length;
        less(target);

        return list;
    }

    private static void less(int target) {
        if (target == 0) {
            list.add(new ArrayList<>(s));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = 0; i < max; i++) {
            s.add(a[i]);
            less(target - a[i]);
            s.remove(s.size() - 1);
        }
    }

    //
    //private static void less(int target) {
    //    for (int i = 0; i < max; i++) {
    //        int less = target - a[i];
    //        s.add(a[i]);
    //        if (k(less)) {
    //            s.remove(s.size() - 1);
    //            break;
    //        }
    //        s.remove(s.size() - 1);
    //    }
    //}
    //
    //private static boolean k(int less) {
    //    if (less > 0) {
    //        less(less);
    //    } else if (less == 0) {
    //        list.add(new ArrayList<>(s));
    //        list.add(s);
    //        return true;
    //    } else {
    //        s.remove(s.size() - 1);
    //        //s = new ArrayList<>();
    //        return true;
    //    }
    //    return false;
    //}

    public static void main(String[] args) {
        int[] a = {1, 2, 4};

        List<List<Integer>> lists = combinationSum(a, 10);
        System.out.println(lists.toString());
    }


    /**
     * 正确解法，来自leetCode
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSums(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);

            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, len, target - candidates[i], path, res);

            // 状态重置
            path.removeLast();
        }
    }
}
