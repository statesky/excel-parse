package com.sina.算法.简单;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * leetcode 1030.
 * <p>
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 * <p>
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 * <p>
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，
 * |r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 * 示例 2：
 * <p>
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 * 示例 3：
 * <p>
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matrix-cells-in-distance-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-11-17
 * @since excel-test 1.0.0
 */
public class 距离顺序排列矩阵单元格 {

    /**
     * 本人
     *
     * 执行用时 16ms    63.50%
     * 内存消耗 41MB    37.67%
     *
     * 最粗暴的方法，先列出所有坐标，再去排序
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int index = 0;
        int [][] result = new int[R * C][2];
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                result[index][0] = j;
                result[index][1] = i;
                index++;
            }
        }

        Arrays.sort(result, (o1, o2) -> Math.abs(r0 - o1[0]) + Math.abs(c0 - o1[1]) - Math.abs(r0 - o2[0]) - Math.abs(c0 - o2[1]));

        return result;
    }

    /**
     * 来自官方
     *
     * 执行用时 9ms     90.87%
     * 内存消耗 40.5MB  92.11%
     *
     * 思路：桶排序 TODO 八大排序需复习
     */
    public int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        List<List<int[]>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new ArrayList<>());
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int d = dist(i, j, r0, c0);
                bucket.get(d).add(new int[]{i, j});
            }
        }
        int[][] ret = new int[R * C][];
        int index = 0;
        for (int i = 0; i <= maxDist; i++) {
            for (int[] it : bucket.get(i)) {
                ret[index++] = it;
            }
        }
        return ret;
    }

    public int dist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    public static void main(String[] args) {
        距离顺序排列矩阵单元格 s = new 距离顺序排列矩阵单元格();
        int a = 2;
        int b = 2;
        int c = 0;
        int d = 1;
        int[][] ints = s.allCellsDistOrder1(a, b, c, d);
        System.out.println(Arrays.deepToString(ints));
    }
}

// 2
//2
//0
//1
