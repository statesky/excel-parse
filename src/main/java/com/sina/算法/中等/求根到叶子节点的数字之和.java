package com.sina.算法.中等;

import com.sina.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode 129.
 * <p>
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * <p>
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * <p>
 * 计算从根到叶子节点生成的所有数字之和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * *     1
 * *    / \
 * *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * <p>
 * 示例 2:
 * <p>
 * 输入: [4,9,0,5,1]
 * *     4
 * *    / \
 * *   9   0
 * *  / \
 * * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-10-29
 * @since excel-test 1.0.0
 */
public class 求根到叶子节点的数字之和 {

    /**
     * 本人，实际上发现是正常的思路，但是表示是一遍过的，哈哈哈哈哈
     *
     * 执行用时 1ms     31.04%
     * 内存消耗 36.2MB  89.82%
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left == null && right == null) {
                list.add(node.val);
            }
            if (left != null) {
                left.val = node.val * 10 + left.val;
                stack.push(left);
            }
            if (right != null) {
                right.val = node.val * 10 + right.val;
                stack.push(right);
            }
        }
        Integer sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }

    /**
     * 来自官方，思路是一样的，但遍历的方法不一样，本人用的是非递归前序遍历，而此处采用的是递归前序遍历
     * 这让我不得不开始怀疑递归比非递归要好用呢
     *
     * 执行用时 0ms     100%
     * 内存消耗 38.8MB  97.72%
     */
    public int sumNumbersFromLeetCode(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

}
