package com.sina.算法;

import com.sina.entity.ListNode;

/**
 * leetcode 2.
 * <p>
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
 * @author zhangbin
 * @version 1.0, 2020-09-11
 * @since excel-test 1.0.0
 */
public class 两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i = l1.getVal() + l2.getVal();
        int a = i / 10;
        int b = i % 10;
        ListNode l3 = new ListNode(b);
        ListNode x = l3;

        l3.setVal(b);
        boolean flag = l1.getNext() == null && l2.getNext() == null;
        while (!(l1.getNext() == null && l2.getNext() == null)) {
            int i1 = l1.getNext() == null ? 0 : l1.getNext().getVal();
            int i2 = l2.getNext() == null ? 0 : l2.getNext().getVal();
            i = i1 + i2 + a;
            a = i / 10;
            b = i % 10;
            ListNode s = new ListNode(b);
            l3.setNext(s);
            l3 = s;
            l1 = l1.getNext() == null ? l1 : l1.getNext();
            l2 = l2.getNext() == null ? l2 : l2.getNext();
        }

        if (a != 0) {
            ListNode s = new ListNode(a);
            l3.setNext(s);
        }

        return x;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.setNext(l2);
        l2.setNext(l3);
        ListNode s1 = new ListNode(5);
        ListNode s2 = new ListNode(6);
        ListNode s3 = new ListNode(4);
        s1.setNext(s2);
        s2.setNext(s3);

        ListNode listNode = new 两数相加().addTwoNumbers(l1, s1);
        System.out.println(listNode);
    }
}
