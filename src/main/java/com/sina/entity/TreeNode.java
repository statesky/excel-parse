package com.sina.entity;

import lombok.Data;

/**
 * The xxx class for xxx.
 *
 * @author zhangbin
 * @version 1.0, 2020-09-27
 * @since excel-test 1.0.0
 */
@Data
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode() {
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
