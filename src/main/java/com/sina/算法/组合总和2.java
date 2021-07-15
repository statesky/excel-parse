package com.sina.算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 40.
 *
 * @author zhangbin
 * @version 1.0, 2020-09-10
 * @since excel-test 1.0.0
 */
public class 组合总和2 {

    //private static int[] a;
    //private static int max;
    //private static List<List<Integer>> list = new ArrayList<>();
    public static List<List<Integer>> result = new LinkedList<>();


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int[] a = candidates;
        Arrays.sort(a);
        int max = a.length;
        dfs(list, a, target, 0, new ArrayList<>(max));

        return list;
    }

    private void dfs(List<List<Integer>> list, int[] a, int target, int j, List<Integer> integers) {
        if (target == 0) {
            list.add(new ArrayList<>(integers));
            return;
        } else if (target < 0 || j >= a.length) {
            return;
        }
        for (int i = j; i < a.length; i++) {
            if (i > j && a[i] == a[i - 1]) {  // 剪枝 + 处理 “重复结果问题”
                continue;
            }
            integers.add(a[i]);
            dfs(list, a, target - a[i], i + 1, integers);
            integers.remove(integers.size() - 1);
        }
    }

    /**
     * 来自leetcode题解
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        comSum2(candidates, target, 0, new LinkedList<>());
        return result;
    }

    public static void comSum2(int[] candidates, int target, int index, LinkedList<Integer> trace) {
        //满足结束条件
        if (target == 0) {
            result.add(new LinkedList(trace));
            return;
        }
        if (target > 0) {
            //选择列表，并加上约束
            for (int i = index; i < candidates.length; i++) {
                //如果以当前结点为头结点的所有组合都找完了，那么下一个与他他相同的头结点就不用去找了。
                if (i > index && candidates[i] == candidates[i - 1]) continue;
                //做出选择
                trace.add(candidates[i]);
                comSum2(candidates, target - candidates[i], i + 1, trace);
                //撤销选择
                trace.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 2, 1, 2};
        int t = 5;
        List<List<Integer>> lists = new 组合总和2().combinationSum2(a, t);
        //List<List<Integer>> list = combinationSum(a, t);
        System.out.println(lists.toString());
        //System.out.println(list.toString());
    }
}
