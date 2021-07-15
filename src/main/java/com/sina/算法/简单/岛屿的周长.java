package com.sina.算法.简单;

/**
 * leetcode 463.
 * <p>
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * <p>
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 * 示例 :
 * <p>
 * 输入:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * 输出: 16
 *
 * @author zhangbin
 * @version 1.0, 2020-10-30
 * @since excel-test 1.0.0
 */
public class 岛屿的周长 {

    /**
     * 本人，此为最笨的方法，毫无技术含量可言，逐个逐个的遍历
     * <p>
     * 执行用时 10ms    48.91%
     * 内存消耗 39.9MB  30.14%
     * <p>
     * 在此基础上可以做优化，只看右边的和下边的，为1则减2，每次照样为4，顶多全减完，不影响
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int column = grid[0].length;
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    int count = 4;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        count--;
                    }
                    if (i + 1 < rows && grid[i + 1][j] == 1) {
                        count--;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        count--;
                    }
                    if (j + 1 < column && grid[i][j + 1] == 1) {
                        count--;
                    }
                    sum = sum + count;
                }
            }
        }

        return sum;
    }

    /**
     * 优化后的
     * <p>
     * 执行用时 6ms     99.90%
     * 内存消耗 39.8MB  34.29%
     *
     * @param grid
     * @return
     */
    public int islandPerimeter2(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;
        int res = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        res -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        res -= 2;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 来自题解，为执行用时最快的那一个
     * <p>
     * 当时看的是 5ms，但实际执行不是
     * <p>
     * 执行用时 8ms     75.57%
     * 内存消耗 39.8MB  44.39%
     *
     * @param grid
     * @return
     */
    public int islandPerimeter1(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                ans += i == 0 ?
                        grid[i][j] : Math.max(grid[i][j] - grid[i - 1][j], 0);
                ans += j == 0 ?
                        grid[i][j] : Math.max(grid[i][j] - grid[i][j - 1], 0);
                ans += i + 1 ==
                        grid.length ? grid[i][j] : Math.max(grid[i][j] - grid[i + 1][j], 0);
                ans += j + 1 ==
                        grid[i].length ? grid[i][j] : Math.max(grid[i][j] - grid[i][j + 1], 0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        岛屿的周长 s = new 岛屿的周长();
        int[][] a = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int i = s.islandPerimeter(a);
        System.out.println(i);
    }
}

//{[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
