package com.sina.算法.中等;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leetcode 973.
 * <p>
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * <p>
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * <p>
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 * <p>
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-11-09
 * @since excel-test 1.0.0
 */
public class 最接近原点的k个点 {

    /**
     * 本人，此方法要考虑数的大小问题
     * <p>
     * 执行用时     13ms    84。54%
     * 内存消耗     46.7MB  89.95%
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        int length = points.length;
        long[] sum = new long[length];

        for (int i = 0; i < length; i++) {
            sum[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            // 将index存入
            sum[i] = sum[i] * 20000 + i;
        }

        Arrays.sort(sum);
        int j = K > length ? length : K;
        int[][] result = new int[j][2];
        for (int i = 0; i < j; i++) {
            int s = (int) (sum[i] % 20000);
            result[i][0] = points[s][0];
            result[i][1] = points[s][1];
        }

        return result;
    }

    /**
     * 来自官方
     * <p>
     * 执行用时 28ms    65.31%
     * 内存消耗 46.9%   79.26%
     * <p>
     * 此思路比我的要好，直接排序，而不计算和等，没文化，真可怕
     * 应是比较的时候比较慢
     */
    public int[][] kClosest1(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });
        // 此方法比自己写的要好
        return Arrays.copyOfRange(points, 0, K);
    }

    /**
     * 来自官方
     *
     * 执行用时 31ms    56.28%
     * 内存消耗 47.2MB  53.42%
     *
     * <p>
     * 思路：优先队列
     * 我们可以使用一个优先队列（大根堆）实时维护前 KK 个最小的距离平方。
     * <p>
     * 首先我们将前 KK 个点的编号（为了方便最后直接得到答案）以及对应的距离平方放入优先队列中，随后从第 K+1K+1 个点开始遍历：
     *  如果当前点的距离平方比堆顶的点的距离平方要小，就把堆顶的点弹出，再插入当前的点。当遍历完成后，所有在优先队列中的点就是前 KK 个距离最小的点。
     * <p>
     * 不同的语言提供的优先队列的默认情况不一定相同。在 C++ 语言中，优先队列即为大根堆，
     *  但在 Python 语言中，优先队列为小根堆，因此我们需要在优先队列中存储（以及比较）距离平方的相反数。
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest2(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                return array2[0] - array1[0];
            }
        });
        for (int i = 0; i < K; ++i) {
            pq.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        int n = points.length;
        for (int i = K; i < n; ++i) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dist < pq.peek()[0]) {
                pq.poll();
                pq.offer(new int[]{dist, i});
            }
        }
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; ++i) {
            ans[i] = points[pq.poll()[1]];
        }
        return ans;
    }

    public static void main(String[] args) {
        最接近原点的k个点 s = new 最接近原点的k个点();
        int[][] a = new int[][]{{-173, 399}, {62, -213}, {71, 282}, {-45, 851}, {710, 982}, {493, 985}, {-529, -946}, {-83, 78}, {624, -785}, {877, -351}, {500, -376}, {-601, -305}, {-23, -79}, {-82, 906}, {-143, 500}, {-249, -260}, {10, 706}, {-904, -632}, {-402, 458}, {303, -970}, {93, -552}, {-362, -743}, {705, 986}, {900, -524}, {-680, -204}, {-726, 890}, {-138, 742}, {-76, 714}, {813, 474}, {443, 23}, {-422, 117}, {768, 214}, {863, 562}, {728, -204}, {778, 147}, {-56, -751}, {240, 454}, {-106, -701}, {-897, -770}, {572, 433}, {-658, 97}, {-301, -466}, {902, -371}, {-38, -662}, {-872, 191}, {659, 294}, {852, 965}, {-37, 665}, {541, -920}, {-537, 704}};
        int k = 20;
        s.kClosest(a, k);
    }
}
//[[-173,399],[62,-213],[71,282],[-45,851],[710,982],[493,985],[-529,-946],[-83,78],[624,-785],[877,-351],[500,-376],[-601,-305],[-23,-79],[-82,906],[-143,500],[-249,-260],[10,706],[-904,-632],[-402,458],[303,-970],[93,-552],[-362,-743],[705,986],[900,-524],[-680,-204],[-726,890],[-138,742],[-76,714],[813,474],[443,23],[-422,117],[768,214],[863,562],[728,-204],[778,147],[-56,-751],[240,454],[-106,-701],[-897,-770],[572,433],[-658,97],[-301,-466],[902,-371],[-38,-662],[-872,191],[659,294],[852,965],[-37,665],[541,-920],[-537,704]]
//20
