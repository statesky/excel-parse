package com.sina.算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 47.
 *
 * @author zhangbin
 * @version 1.0, 2020-09-18
 * @since excel-test 1.0.0
 */
public class 全排列2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> sums = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);

        dfs(nums, 0,  new ArrayList<>(), sums);

        return sums;
    }

    private void dfs(int[] nums, Integer index, List<Integer> list, List<List<Integer>> sums) {
        if (list.size() == nums.length) {
            sums.add(new ArrayList<>(list));
            return;
        }
        if (index > 0 && nums[index] == nums[index - 1]) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[index]);
            dfs(nums, index + 1, list, sums);
        }
    }

}
