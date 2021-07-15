package com.sina.算法.中等;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * leetcode 116.
 * <p>
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * * struct Node {
 * *   int val;
 * *   Node *left;
 * *   Node *right;
 * *   Node *next;
 * * }
 * <p>
 * <p>
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * 示例（由于为图片，故无，简单来讲就是每一个节点都与右方下一个节点连接：
 * 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":
 * {"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6",
 * "left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7",
 * "left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * <p>
 * 输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":
 * {"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6}
 * ,"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},
 * "val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 * <p>
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-10-15
 * @since excel-test 1.0.0
 */
public class 填充每个节点的下一个右侧节点指针 {

    /**
     * 本人想法，
     * 执行用时 19.48%，4ms
     * 内存消耗 97.15%，38.7MB
     *
     * @param root
     * @return
     */
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }

        ArrayDeque<Node> deque = new ArrayDeque<>();
        ArrayDeque<Node> dequeNew = new ArrayDeque<>();
        ArrayDeque<Node> dequeTransfer;
        deque.addLast(root);

        do {
            Node node = deque.removeFirst();
            node.next = deque.peekFirst();
            if (node.left != null) {
                dequeNew.offerLast(node.left);
                dequeNew.offerLast(node.right);
            }

            if (deque.peekFirst() == null) {
                dequeTransfer = deque;
                deque = dequeNew;
                dequeNew = dequeTransfer;
            }
        } while (deque.peekFirst() != null);

        return root;
    }

    /**
     * 来自leetcode题解
     * 执行用时 1008%，0ms
     * 内存消耗 99.56%，38.5MB
     *
     * 此方式除了 new 了几个 node 作为辅助，没有用到其他耗资源的辅助
     * 相比于本人还利用了 ArrayDeque，并且在从中存取元素应也耗费了大量时间，故很慢
     * @param root
     * @return
     */
    public static Node connectForLeetCode1(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            Node node = new Node(0);
            Node pre = node;

            while (cur != null && cur.left != null) {
                pre.next = cur.left;
                pre = pre.next;
                pre.next = cur.right;
                pre = pre.next;
                cur = cur.next;
            }
            cur = node.next;
        }

        return root;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        Node connect = connectForLeetCode1(node1);
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        public void addLeft(Node node) {
            this.left = node;
        }

        public void addRight(Node node) {
            this.right = node;
        }
    }

}
