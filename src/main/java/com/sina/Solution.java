package com.sina;

import com.sina.entity.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The xxx class for xxx.
 *
 * @author zhangbin
 * @version 1.0, 2020-05-27
 * @since excel-test 1.0.0
 */
public class Solution {

    //    给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。假定 1<=k<=数组长度
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ints = new int[k];
        int[] maxs = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            ints[i] = nums[1];
        }
        Arrays.sort(ints);
        maxs[0] = ints[k - 1];
        for (int i = 1; i <= nums.length - k; i++) {
            if (maxs[i - 1] > nums[k + i - 1]) {
                maxs[i] = maxs[i - 1];
            } else {
                maxs[i] = nums[k + i - 1];
            }
        }
        return maxs;
    }


    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbersFirst(ListNode l1, ListNode l2) {
        int i = 0;
        int j = l1.getVal() + l2.getVal();

        i = j / 10;
        ListNode sum = new ListNode(j % 10);
        ListNode sums = sum;
        while (l1.getNext() != null && l2.getNext() != null) {
            l1 = l1.getNext();
            l2 = l2.getNext();
            j = l1.getVal() + l2.getVal() + i;

            i = j / 10;
            ListNode sumNext = new ListNode(j % 10);
            sums.setNext(sumNext);
            sums = sumNext;
        }

        while (l1.getNext() != null) {
            j = l1.getVal() + i;
            sums.setNext(new ListNode(j % 10));
            sums = new ListNode(j % 10);
            i = j / 10;
            if (i == 1) {
                sums.setNext(new ListNode(1));
            }
        }

        while (l2.getNext() != null) {
            j = l2.getVal() + i;
            sums.setNext(new ListNode(j % 10));
            sums = new ListNode(j % 10);
            if (j / 10 == 1) {
                sums.setNext(new ListNode(1));
            }
        }


        if (i == 1) {
            sums.setNext(new ListNode(i));
        }

        return sum;
    }

    /**
     * 阅读解法后转化
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbersSecond(ListNode l1, ListNode l2) {



        return null;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l1.setNext(l2);
        l2.setNext(l3);
        l4.setNext(l5);
        l5.setNext(l6);

        ListNode listNode = addTwoNumbersFirst(l1, l4);
    }
}
