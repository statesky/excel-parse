package com.sina.entity;

import lombok.Data;

/**
 * The xxx class for xxx.
 *
 * @author zhangbin
 * @version 1.0, 2020-05-28
 * @since excel-test 1.0.0
 */
@Data
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
