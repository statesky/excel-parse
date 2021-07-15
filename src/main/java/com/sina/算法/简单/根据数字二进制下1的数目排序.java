package com.sina.算法.简单;

import java.util.*;

/**
 * leetcode 1356.
 * <p>
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * <p>
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * <p>
 * 请你返回排序后的数组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * 示例 2：
 * <p>
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 * 示例 3：
 * <p>
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 * 示例 4：
 * <p>
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 * 示例 5：
 * <p>
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-11-06
 * @since excel-test 1.0.0
 */
public class 根据数字二进制下1的数目排序 {

    /**
     * 本人
     * 思路：先排序，建立一个Map<Integer, List<Integer>> map,再开始从头遍历，
     *
     * 执行用时 11ms    37.33%
     * 内存消耗 39MB    64.06%
     *
     * 这是一种很暴力的方法，没想到其他的比较好的方法了
     */
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i : arr) {
            String s = Integer.toBinaryString(i);
            int sum = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    sum++;
                }
            }
            if (map.containsKey(sum)) {
                List<Integer> list = map.get(sum);
                list.add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(sum, list);
            }
        }

        List<Integer> integerList = new ArrayList<>(map.keySet());

        Integer[] integers = integerList.toArray(new Integer[0]);

        Arrays.sort(integers);

        int[] result = new int[arr.length];
        int index = 0;
        for (Integer i : integers) {
            List<Integer> list = map.get(i);
            for (Integer j : list) {
                result[index] = j;
                index++;
            }
        }

        return result;
    }

    /**
     * 来自题解
     *
     * 执行用时 3ms     100%
     * 内存消耗 38.7MB  88.06%
     *
     * 这简直牛皮，思路很巧妙，Integer.bitCount(arr[i]) 可得出 1 的个数，这是我不知道的，之后就直接乘了，然后再排序，最后在取余，666
     */
    public int[] sortByBits1(int[] arr) {
        int[] list = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            list[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(list);
        for (int i = 0; i < list.length; i++) {
            list[i] = list[i] % 10000000;
        }
        return list;
    }

    /**
     * 来自官方
     *
     * 执行用时 12ms    34.14%
     * 内存消耗 39MB    68.08%
     */
    public int[] sortByBits2(int[] arr) {
        int[] bit = new int[10001];
        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            list.add(x);
            bit[x] = get(x);
        }
        list.sort((x, y) -> {
            if (bit[x] != bit[y]) {
                return bit[x] - bit[y];
            } else {
                return x - y;
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 2;
            x /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        根据数字二进制下1的数目排序 s = new 根据数字二进制下1的数目排序();
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        //int[] ints = s.sortByBits1(arr);
        int[] ints2 = s.sortByBits2(arr);
        System.out.println(Arrays.toString(ints2));
    }
}

//[0,1,2,3,4,5,6,7,8]
