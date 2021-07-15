package com.sina.算法;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * leetCode 77.
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-09-08
 * @since excel-test 1.0.0
 */
public class 组合 {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        if (k == 0 || n < k) {
            return lists;
        } else {
            for (int i = 1; i <= n; i++) {
                List<Integer> arrays = new ArrayList<>();
                arrays.add(i);
                lists.add(arrays);
            }
            if (k == 1) {
                return lists;
            } else {
                for (int i = 2; i <= k; i++) {
                    Iterator<List<Integer>> iterator = lists.iterator();
                    List<List<Integer>> lists2 = new ArrayList<>();
                    while (iterator.hasNext()) {
                        List<Integer> arrays = iterator.next();
                        //iterator.remove();
                        Integer last = arrays.get(arrays.size() - 1);
                        if (last >= n) {
                            break;
                        }
                        for (int j = last + 1; j <= n; j++) {
                            List<Integer> integers = new ArrayList<>(arrays);
                            integers.add(j);
                            lists2.add(integers);
                        }
                    }
                    lists = lists2;
                }
                return lists;
            }
        }
    }

    public static void main(String[] args) {
        //ArrayQueue<Integer> integers = new ArrayQueue<>(10);
        ArrayDeque<Integer> integers = new ArrayDeque<>(10);
        List<List<Integer>> combine = combine(3, 3);
        System.out.println(combine);
    }
}
