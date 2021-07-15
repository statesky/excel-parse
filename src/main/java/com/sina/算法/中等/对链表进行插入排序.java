package com.sina.算法.中等;

import com.sina.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 147.
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-11-20
 * @since excel-test 1.0.0
 */
public class 对链表进行插入排序 {

    /**
     * 本人
     *
     * 执行用时 47ms    5.01%
     * 内存消耗 38.2MB  75.86%
     *
     * 思路：先存入list，再进行插入排序，最后输出，知道慢，没想到这么慢
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        ListNode node = head.next;
        while (node != null) {
            for (int i = list.size() - 1; i >= 0; i--) {
                ListNode a = list.get(i);
                if (node.val >= a.val) {
                    list.add(i + 1, node);
                    break;
                }
                if (i == 0) {
                    list.add(0, node);
                }
            }
            node = node.next;
        }

        head = list.get(0);
        node = head;

        for (int i = 1; i < list.size(); ++i) {
            node.next = list.get(i);
            node = node.next;
        }

        node.next = null;
        return list.get(0);
    }

    /**
     * 官网
     *
     * 执行用时 3ms     98.81%
     * 内存消耗 38.3MB  63.38%
     *
     * 没想到差距如此之大
     */
    public ListNode insertionSortList1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        对链表进行插入排序 s = new 对链表进行插入排序();
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(1);
        ListNode listNode = s.insertionSortList1(node);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
