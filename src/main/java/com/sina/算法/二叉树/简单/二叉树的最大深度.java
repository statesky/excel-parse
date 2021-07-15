package com.sina.算法.二叉树.简单;

import com.sina.entity.TreeNode;

/**
 * leetcode 104.
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2021-02-23
 * @since excel-test 1.0.0
 */
public class 二叉树的最大深度 {

    /**
     * 执行用时 0ms     100%
     * 内存消耗 38.5MB  31.49%
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        二叉树的最大深度 s = new 二叉树的最大深度();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        int i = s.maxDepth(node1);

        System.out.println(i);
    }
}


//dove:sms:send:cs:id:captcha-register:12345:redis:key
//dove:sms:send:cs:id:captcha-register:12345:redis:key
//dove:sms:send:cs:id:captcha-register:205905107668172865:redis:key
