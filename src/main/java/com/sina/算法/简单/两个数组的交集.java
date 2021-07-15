package com.sina.算法.简单;

import java.util.*;

/**
 * leetcode 349.
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-11-02
 * @since excel-test 1.0.0
 */
public class 两个数组的交集 {

    /**
     * 本人，未利用到返回的是唯一的，而不带重复的，但意外的快
     * <p>
     * 执行用时 2ms     99.48%
     * 内存消耗 38.8MB  79.33%
     * <p>
     * 此方法很传统，先排序，然后再比较，用list接收，最后再转成 int[]
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // 先分别排序，以方便下面的比较
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int a = nums1.length;
        int b = nums2.length;

        int c = 0;
        int d = 0;

        List<Integer> list = new ArrayList<>();

        while (c < a && d < b) {
            // 去重
            if (c > 0 && nums1[c] == nums1[c - 1]) {
                c++;
                continue;
            }
            if (d > 0 && nums2[d] == nums2[d - 1]) {
                d++;
                continue;
            }
            // 比较
            if (nums1[c] < nums2[d]) {
                c++;
            } else if (nums1[c] == nums2[d]) {
                list.add(nums1[c]);
                c++;
                d++;
            } else {
                d++;
            }
        }

        return getInts(list);
    }

    /**
     * 本人，采用了set的方式
     * <p>
     * 执行用时 3ms     95.82%
     * 内存消耗 38.9MB  67.36%
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        int a = nums1.length;
        int b = nums2.length;
        int[] c;
        int[] d;
        if (a > b) {
            c = nums2;
            d = nums1;
        } else {
            c = nums1;
            d = nums2;
        }
        Set<Integer> set = new HashSet<>(a);

        List<Integer> list = new ArrayList<>(a);
        for (int i : c) {
            set.add(i);
        }
        for (int i : d) {
            if (set.contains(i)) {
                list.add(i);
                set.remove(i);
            }
        }

        return getInts(list);
    }

    private int[] getInts(List<Integer> list) {
        int[] sum = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            sum[i] = list.get(i);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 6, 2, 9, 1};
        int[] b = new int[]{7, 1};

        两个数组的交集 s = new 两个数组的交集();
        int[] ints = s.intersection2(a, b);
        System.out.println(Arrays.toString(ints));
    }

    //public int[] intersection3(int[] num1, int[] num2) {
    //    Arrays.sort(num1);
    //    Arrays.sort(num2);
    //
    //    int length = num1.length > num2.length ? num2.length : num1.length;
    //    int[] sum = new int[length];
    //    List<Integer> list = new ArrayList<>();
    //
    //    int aIndex = 0;
    //    int bIndex = 0;
    //    while (aIndex < num1.length && bIndex < num2.length) {
    //        if (num1[aIndex] == num2[bIndex]) {
    //            list.add(num2[bIndex]);
    //            aIndex++;
    //            bIndex++;
    //        } else if (num1[aIndex] < num2[bIndex]) {
    //            aIndex++;
    //        } else {
    //            bIndex++;
    //        }
    //    }
    //
    //    return sum;
    //
    //}
}

// [2,6,2,9,1]
// [7,1]
