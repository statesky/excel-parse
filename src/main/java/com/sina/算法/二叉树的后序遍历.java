package com.sina.算法;

import com.sina.entity.TreeNode;

import java.util.*;

/**
 * leetcode 145.
 * <p>
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * 输入: [1,null,2,3]
 * *    1
 * *     \
 * *      2
 * *     /
 * *    3
 * <p>
 * 输出: [3,2,1]
 *
 * @author zhangbin
 * @version 1.0, 2020-09-29
 * @since excel-test 1.0.0
 */
public class 二叉树的后序遍历 {

    /**
     * 简单的递归遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        dfs(root, list);
        return list;
    }


    public void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        dfs(node.right, list);
        /**
         * 前中后只要相应的移动此行代码位置
         */
        list.add(node.val);
    }

    /**
     * 进阶的非递归遍历，前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalPre(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                list.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return list;
    }


    /**
     * 非递归后序遍历
     */
    public List<Integer> postOrderNonCur(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null)
            return resultList;
        Map<TreeNode, Integer> visitedMap = new HashMap<>();
        Stack<TreeNode> toBeVisitedStack = new Stack<>();
        toBeVisitedStack.push(root);
        while (!toBeVisitedStack.isEmpty()) {
            TreeNode tempNode = toBeVisitedStack.peek(); //注意这里是peek而不是pop
            if (tempNode.left == null && tempNode.right == null) { //如果没有左右孩子则访问
                resultList.add(tempNode.val);
                visitedMap.put(tempNode, 1);
                toBeVisitedStack.pop();
                continue;
            } else if (!((tempNode.left != null && visitedMap.get(tempNode.left) == null) || (tempNode.right != null && visitedMap.get(tempNode.right) == null))) {
                //如果节点的左右孩子均已被访问
                resultList.add(tempNode.val);
                toBeVisitedStack.pop();
                visitedMap.put(tempNode, 1);
                continue;
            }
            if (tempNode.left != null) {
                while (tempNode.left != null && visitedMap.get(tempNode.left) == null) {//左孩子没有被访问
                    toBeVisitedStack.push(tempNode.left);
                    tempNode = tempNode.left;
                }
            }
            if (tempNode.right != null) {
                if (visitedMap.get(tempNode.right) == null) {//右孩子没有被访问
                    toBeVisitedStack.push(tempNode.right);
                }
            }
        }
        return resultList;
    }
}
