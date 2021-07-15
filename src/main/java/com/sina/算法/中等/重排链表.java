package com.sina.算法.中等;

import com.sina.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 143.
 * <p>
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-10-29
 * @since excel-test 1.0.0
 */
public class 重排链表 {

    /**
     * 本人，和官方思路一一致
     *
     * 执行用时 4ms     42.70%
     * 内存消耗40.8MB   60.76%
     * @param head
     * @return
     */
    public ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();

        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }

        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        Integer[] sum = new Integer[list.size()];
        Integer[] integers = list.toArray(new Integer[list.size()]);
        list.get(i).next = null;
        return list.get(0);
    }
}
