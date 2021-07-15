package com.sina.算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode 94.
 * <p>
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * * 1
 * *  \
 * *   2
 * *  /
 * * 3
 * <p>
 * 输出: [1,3,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-09-14
 * @since excel-test 1.0.0
 */
public class 二叉树的中序遍历 {

    /**
     * 此为递归解法， 内存消耗贼大
     * * public class TreeNode {
     * *     int val;
     * *     TreeNode left;
     * *     TreeNode right;
     * *     TreeNode(int x) { val = x; }
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            infixOrder(root, list);
        }
        return list;
    }

    public void infixOrder(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            infixOrder(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            infixOrder(node.right, list);
        }
    }

    /**
     * 迭代 --- 错误的解答，会形成死循环，
     * 用栈的原因是因为我们需要一种工具来记录上父节点，或类似的理念，所以才引入
     * 相比于数组和队列，明显是栈更合适
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack.empty()) {
            root = stack.peek();
            if (root.left != null) {
                stack.push(root.left);
                continue;
            } else {
                TreeNode pop = stack.pop();
                list.add(pop.val);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }

        return list;
    }


    /**
     * 迭代 --- 来自题解
     * 此题解思路是不断的遍历树的左子节点和根，并将下一个根变为最后一个左子节点对应的右子节点
     * 就像是一个原本的树，而该代码不断的遍历该树的最左未遍历斜线，以达到遍历的目的
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
    }


    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
