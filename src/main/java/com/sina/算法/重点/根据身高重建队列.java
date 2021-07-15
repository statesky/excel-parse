package com.sina.算法.重点;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * leetcode 406.
 * <p>
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * <p>
 * 注意：
 * 总人数少于1100人。
 * <p>
 * 示例
 * <p>
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-11-16
 * @since excel-test 1.0.0
 */
public class 根据身高重建队列 {

    /**
     * 本人，
     * <p>
     * 执行用时 19ms    11.38%
     * 内存消耗 39.5MB  77.97%
     * <p>
     * 思路，
     * * 方法传统，先排序，再依次遍历，拿到people[i][1]，在另一个记录位数的数组中找出，他应该在的地方，填进去。直至结束
     * * 但是没想到这么慢
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        //
        //Arrays.sort(people, new Comparator<int[]>() {
        //    @Override
        //    public int compare(int[] o1, int[] o2) {
        //        if (o1[0] > o2[0]) {
        //            return 1;
        //        } else if (o1[0] < o2[0]) {
        //            return -1;
        //        } else {
        //            if (o1[1] > o2[1]) {
        //                return 1;
        //            } else {
        //                return -1;
        //            }
        //        }
        //    }
        //});

        int length = people.length;
        int[][] result = new int[length][2];

        int[] count = new int[length];
        //Arrays.fill(count, Integer.MAX_VALUE);

        for (int i = 0; i < length; ++i) {
            int person = people[i][1];
            int j = 0;
            while (i - j > 0) {
                if (people[i][0] == people[i - (j + 1)][0]) {
                    j++;
                } else {
                    break;
                }
            }
            int i1 = person - j;
            int k;
            for (k = 0; k < length; ++k) {
                if (count[k] == 0) {
                    i1--;

                    if (i1 < 0) {
                        count[k] = 1;
                        break;
                    }
                }
            }

            result[k][0] = people[i][0];
            result[k][1] = people[i][1];

        }

        return result;
    }

    /**
     * 来自官方
     *
     * 执行用时 20Mms   10.78%
     * 内存消耗 39.3MB  91.55%
     *
     * 思路类似
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue1(int[][] people) {
        // TODO 排序这样写才好
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person1[0] - person2[0];
                } else {
                    return person2[1] - person1[1];
                }
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < n; ++i) {
                // 为null则表示未填入，减1
                if (ans[i] == null) {
                    --spaces;
                    // 等于0即填入
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public int[][] reconstructQueue2(int[][] people) {
        // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        // 再一个一个插入。
        // [7,0]
        // [7,0], [7,1]
        // [7,0], [6,1], [7,1]
        // [5,0], [7,0], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }

        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        根据身高重建队列 s = new 根据身高重建队列();
        int[][] a = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ints = s.reconstructQueue2(a);
        System.out.println(Arrays.deepToString(ints));
    }
}
//{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}}
