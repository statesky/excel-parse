package com.sina.算法.重点;

import java.util.Arrays;

/**
 * leetcode 31.
 * <p>
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-11-10
 * @since excel-test 1.0.0
 */
public class 下一个排列 {

    /**
     * 本人，算法有问题
     */
    public int[] nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int length = nums.length;
        int min = nums[length - 1];
        int index = length - 1;
        // 此处有问题
        for (int i = length - 2; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                int j = length - 1;
                while (j  > i) {
                    if (nums[j] > nums[i]) {
                        int t = nums[i];
                        nums[i] = nums [j];
                        nums[j] = t;
                        break;
                    }
                    j--;
                }
                break;
            }
        }
        int begin;
        int end = length - 1;
        if (index == length - 1) {
            begin = 0;
        } else {
            begin = index + 1;
        }
        int tmp;
        while (begin < end) {
            tmp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = tmp;

            begin++;
            end--;
        }

        return nums;
    }

    /**
     * 来自官方，思路类似，但更优，我是靠蒙的
     *
     * 执行用时 1ms     98.72%
     * 内存消耗 38.5MB  91.37%
     *
     * 注意到下一个排列总是比当前排列要大，除非该排列已经是最大的排列。我们希望找到一种方法，能够找到一个大于当前序列的新序列，且变大的幅度尽可能小。具体地：
     *
     * 我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
     *
     * 同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
     *
     * 以排列 [4,5,2,6,3,1][4,5,2,6,3,1] 为例：
     *
     * 我们能找到的符合条件的一对「较小数」与「较大数」的组合为 22 与 33，满足「较小数」尽量靠右，而「较大数」尽可能小。
     *
     * 当我们完成交换后排列变为 [4,5,3,6,2,1][4,5,3,6,2,1]，此时我们可以重排「较小数」右边的序列，序列变为 [4,5,3,1,2,6][4,5,3,1,2,6]。
     *
     * 具体地，我们这样描述该算法，对于长度为 nn 的排列 aa：
     *
     * 首先从后向前查找第一个顺序对 (i,i+1)(i,i+1)，满足 a[i] < a[i+1]a[i]<a[i+1]。这样「较小数」即为 a[i]a[i]。此时 [i+1,n)[i+1,n) 必然是下降序列。
     *
     * 如果找到了顺序对，那么在区间 [i+1,n)[i+1,n) 中从后向前查找第一个元素 jj 满足 a[i] < a[j]a[i]<a[j]。这样「较大数」即为 a[j]a[j]。
     *
     * 交换 a[i]a[i] 与 a[j]a[j]，此时可以证明区间 [i+1,n)[i+1,n) 必为降序。我们可以直接使用双指针反转区间 [i+1,n)[i+1,n) 使其变为升序，而无需对该区间进行排序。
     *
     * @param nums
     */
    public void nextPermutation1(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        下一个排列 s = new 下一个排列();
        int[] a = new int[]{2, 3, 1};
        int[] ints = s.nextPermutation(a);
        System.out.println(Arrays.toString(ints));

    }
}

//[1,2,3]
