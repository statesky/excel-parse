package com.sina.算法.简单;

import com.sina.entity.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The xxx class for xxx.
 *
 * @author zhangbin
 * @version 1.0, 2020-10-23
 * @since excel-test 1.0.0
 */
public class 回文链表 {

    /**
     * 本人
     * 不了解回文链表的含义，此算法未通过，看了一下官网题解，比较简单，故未改进
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(head.getVal());
        while (head.next != null) {
            ListNode next =  head.next;
            if (stack.empty()) {
                stack.push(next.val);
            } else {
                Integer node = stack.peek();
                if (node == next.val) {
                    stack.pop();
                } else {
                    stack.push(next.val);
                }
            }
            head = head.next;
        }

        return stack.empty();
    }

    /**
     * 来自官网
     *
     * 将链表转换为数组，然后首尾两个指针向中间移动，判断是否相等，以此判断是否为回文链表
     *
     * 执行用时4ms
     *
     * @param head
     * @return
     */
    public boolean isPalindromeFromLeetCode(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    /**
     * 来自大神
     *
     *
     * @param head
     * @return
     */
    public boolean isPalindromeFromPeoper(ListNode head) {
        ListNode fast = head, slow = head;
        //通过快慢指针找到中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果fast不为空，说明链表的长度是奇数个
        if (fast != null) {
            slow = slow.next;
        }
        //反转后半部分链表
        slow = reverse(slow);

        fast = head;
        while (slow != null) {
            //然后比较，判断节点值是否相等
            if (fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    //反转链表
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
