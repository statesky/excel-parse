package com.sina.算法.中等;

import com.sina.entity.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * The xxx class for xxx.
 *
 * @author zhangbin
 * @version 1.0, 2021-03-02
 * @since excel-test 1.0.0
 */
public class 二维区域和检索_矩阵不可变 {

    private int[][] sums;

    /**
     * 来自官方
     * 与前一种方法一致
     * <p>
     * 执行用时 15ms    60.40%
     * 内存消耗 44.1MB  55.00%
     *
     * @param matrix
     */
    public 二维区域和检索_矩阵不可变(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            sums = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i][j + 1] = sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += sums[i][col2 + 1] - sums[i][col1];
        }
        return sum;
    }

    public static void main(String[] args) {
        Map<Long, ListNode> map = new HashMap<>();
        ListNode node = new ListNode();
        node.setVal(1);

        map.put(111L, node);
        System.out.println(map);


    }
}
