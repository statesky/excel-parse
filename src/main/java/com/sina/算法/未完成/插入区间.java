package com.sina.算法.未完成;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 57.
 * <p>
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-11-04
 * @since excel-test 1.0.0
 */
public class 插入区间 {

    /**
     * 本人，未完成，大致思路是先判空，之后再分别比较，但忽略了新的和原来的都不重叠的情况，
     * 这种情况可将removeBegin和removeEnd用小数表示，但已放弃
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //int length = intervals.length;
        //// 判空
        //
        //int removeBegin = -1;
        //int removeEnd = -1;
        //int index = 0;
        //int begin = newInterval[0];
        //int end = newInterval[1];
        //int[] sum = new int[2];
        //while (index < length) {
        //    int a = intervals[index][0];
        //    int b = intervals[index][1];
        //    // 判断是否找出起始点
        //    if (removeBegin == -1) {
        //        if (b < begin) {
        //
        //        } else if (b == begin) {
        //            sum[0] = a;
        //            removeBegin = index;
        //        } else (b > begin) {
        //            removeBegin = index;
        //            if (begin >= a) {
        //                sum[0] = a;
        //            } else {
        //                sum[0] = begin;
        //            }
        //            if (b >= end) {
        //                removeEnd = index;
        //                sum[1] = b;
        //            }
        //        }
        //    } else {
        //        // 开始找终点
        //        if (b < end) {
        //
        //        } else if (b == end) {
        //            sum[1] = b;
        //            removeEnd = index;
        //            break;
        //        } else if (b > end) {
        //            if (a <= end) {
        //                sum[1] = b;
        //                removeEnd = index;
        //            } else (a > end) {
        //                sum[1] = end;
        //                removeEnd = index--;
        //                break;
        //            }
        //        }
        //    }
        //    index++;
        //}
        //
        //if (removeBegin == -1) {
        //    removeBegin = length;
        //    removeEnd = length;
        //    sum[0] = begin;
        //    sum[1] = end;
        //}
        //if (removeEnd == -1) {
        //    removeEnd = length;
        //    sum[1] = end;
        //}
        int index = 0;
        int begin = newInterval[0];
        int end = newInterval[1];

        // 不知道还可以这样，我吐了
        List<int[]> list = new ArrayList<>();

        while (true) {
            int a = intervals[index][0];
            int b = intervals[index][1];
            // 判断是否找出起始点
            if (b < begin) {
                list.add(intervals[index]);
                continue;
            }
            //if ()
            //else if (b == begin) {
            //    sum[0] = a;
            //    removeBegin = index;
            //} else (b > begin) {
            //    removeBegin = index;
            //    if (begin >= a) {
            //        sum[0] = a;
            //    } else {
            //        sum[0] = begin;
            //    }
            //    if (b >= end) {
            //        removeEnd = index;
            //        sum[1] = b;
            //    }
            //}
        }

        // while
    }

    /**
     * 来自官方
     * 发现还是要先理清思路，再开始写，不然会很麻烦
     *
     *
     */
    public int[][] insertFromLeetCode(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;

    }

    public static void main(String[] args) {
        插入区间 s = new 插入区间();
        int[][] a = new int[][]{{1, 3}, {6, 9}};
        int[] b = new int[]{2, 5};

        int[][] ints = s.insertFromLeetCode(a, b);

    }
}

//[[1,3],[6,9]]
//[2,5]
