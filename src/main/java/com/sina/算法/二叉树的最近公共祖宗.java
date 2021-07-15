package com.sina.算法;

import com.sina.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * leetcode 235.
 *
 * @author zhangbin
 * @version 1.0, 2020-09-27
 * @since excel-test 1.0.0
 */
public class 二叉树的最近公共祖宗 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        List<List<TreeNode>> lists = new ArrayList<>();
        ArrayDeque<TreeNode> list = new ArrayDeque<>();
        list.addLast(root);
        dfs(root, p, q, list, lists);
        if (lists.size() != 2) {
            return null;
        }
        List<TreeNode> treeNodes1 = lists.get(0);
        List<TreeNode> treeNodes2 = lists.get(1);
        int length = treeNodes1.size() > treeNodes2.size() ? treeNodes2.size() : treeNodes1.size();
        for (int i = 0; i < length; i++) {
            if (treeNodes1.get(i).getVal() != treeNodes2.get(i).getVal()) {
                return treeNodes1.get(i - 1);
            }
        }
        return treeNodes1.get(length - 1);
    }

    private void dfs(TreeNode node, TreeNode p, TreeNode q, Deque<TreeNode> treeNodes, List<List<TreeNode>> lists) {
        if (lists.size() == 2) {
            return;
        }
        if (node == null) {
            return;
        }
        if (node.getVal() == p.getVal() || node.getVal() == q.getVal()) {
            lists.add(new ArrayList<>(treeNodes));
        }

        if (node.getLeft() != null) {
            treeNodes.addLast(node.getLeft());
            dfs(node.getLeft(), p, q, treeNodes, lists);
            treeNodes.removeLast();
        }

        if (node.getRight() != null) {
            treeNodes.addLast(node.getRight());
            dfs(node.getRight(), p, q, treeNodes, lists);
            treeNodes.removeLast();
        }
    }

    public Boolean equals(TreeNode t1, TreeNode t2) {
        if (t1 == t2) {
            return true;
        }
        return t1.getVal() == t2.getVal() && t1.getLeft() == t2.getLeft() && t1.getRight() == t2.getRight();
    }

    //[6,2,8,0,4,7,9,null,null,3,5]
    //2
    //8
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(5);

        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        node4.setLeft(node7);
        node4.setRight(node8);

        TreeNode node = new 二叉树的最近公共祖宗().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
        System.out.println(node.getVal());
    }
}
