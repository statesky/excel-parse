package com.sina.算法.中等;

/**
 * leetcode 845.
 * <p>
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * <p>
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * <p>
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * <p>
 * 如果不含有 “山脉” 则返回 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 * <p>
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-mountain-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author zhangbin
 * @version 1.0, 2020-10-19
 * @since excel-test 1.0.0
 */
public class 数组中的最长山脉 {

    /**
     * 本人方法一
     * 此方法效率良好，但很令人讨厌，太麻烦了
     * <p>
     * 执行用时：2ms     100%/一般为 3ms    70%
     * 内存消耗：39.5MpB 94%
     * <p>
     * 看着就不太容易看懂，而且贼麻烦，需要分别考虑各种情况，故有了第二种
     */
    private int longestMountain1(int[] A) {
        int max = 0;
        int sum = 1;
        int count = 1;
        boolean flag = true;

        for (int i = 1; i < A.length; i++) {
            if (flag) {
                if (A[i] > A[i - 1]) {
                    sum++;
                } else if (A[i] < A[i - 1]) {
                    if (sum >= 2) {
                        sum++;
                        count++;
                    }
                    flag = false;
                } else {
                    sum = 1;
                }
            } else {
                if (sum < 2) {
                    if (A[i] == A[i - 1]) {
                        sum = 1;
                        flag = true;
                    } else if (A[i] > A[i - 1]) {
                        sum = 2;
                        flag = true;
                    }
                } else {
                    if (A[i] < A[i - 1]) {
                        sum++;
                        count++;
                    } else if (A[i] == A[i - 1]) {
                        if (count >= 2 && max < sum) {
                            max = sum;
                        }
                        flag = true;
                        count = 1;
                        sum = 1;
                    } else {
                        if (count >= 2 && max < sum) {
                            max = sum;
                        }
                        sum = 2;
                        count = 1;
                        flag = true;
                    }
                }
            }
        }
        if (max < sum && count >= 2) {
            max = sum;
        }
        if (max < 3) {
            return 0;
        }
        return max;
    }

    /**
     * 考虑用两个计数器分别计数，一个专门记升序数量，一个专门记降序数量，都大于2则count = a + b - 1;
     * 用指针或for循环往后遍历，直到结束，用max统计最大，且在结束同样判断 a，b
     * 发现不能好的区分上升和下井，此来自官网
     * <p>
     * 执行用时:    3ms     70.07%
     * 内存消耗:    39.3 MB 98.17%
     */
    public int longestMountain2(int[] A) {
        int N = A.length;
        int ans = 0, base = 0;
        while (base < N) {
            int end = base;
            // if base is a left-boundary
            if (end + 1 < N && A[end] < A[end + 1]) {
                // set end to the peak of this potential mountain
                while (end + 1 < N && A[end] < A[end + 1]) end++;

                // if end is really a peak..
                if (end + 1 < N && A[end] > A[end + 1]) {
                    // set end to the right-boundary of mountain
                    while (end + 1 < N && A[end] > A[end + 1]) end++;
                    // record candidate answer
                    ans = Math.max(ans, end - base + 1);
                }
            }

            base = Math.max(end, base + 1);
        }

        return ans;
    }


    public static void main(String[] args) {
        数组中的最长山脉 s = new 数组中的最长山脉();
        int[] a = new int[]{2, 1, 4, 7, 3, 2, 5};
        int i1 = s.longestMountain2(a);
        System.out.println(i1);
    }
}

// [0,1,2,3,4,5,4,3,2,1,0]
// [2,1,4,7,3,2,5]
