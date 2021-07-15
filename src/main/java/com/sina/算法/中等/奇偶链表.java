package com.sina.算法.中等;

import com.sina.entity.ListNode;

/**
 * leetcode 326.
 * <p>
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-11-13
 * @since excel-test 1.0.0
 */
public class 奇偶链表 {

    /**
     * 本人
     *
     * 执行用时 0ms     100%
     * 内存消耗 37.9MB  95.40%
     *
     * 思路：创建一个临时节点，并使一个节点指至头结点
     * 奇数位相连，偶数位连在tmp节点之后，最后使原尾结点.next = tmp.next以连接，当然一定要注意死循环
     *
     * 一定要注意判空
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode c = head;
        ListNode tmp = new ListNode();
        ListNode a = tmp;
        while (head.next != null) {
            ListNode b = head.next;
            a.next = b;
            a = b;
            if (b.next != null) {
                head.next = b.next;
                head = b.next;
            } else {
                break;
            }
        }
        // 以防此next指定tmp最后一个节点，形成死循环
        a.next = null;
        head.next = tmp.next;
        return c;
    }

    public static void main(String[] args) {
        奇偶链表 s = new 奇偶链表();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = s.oddEvenList(head);
        while (listNode.next != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

// [1,2,3,4,5]
