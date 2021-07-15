package com.sina.算法.简单;

/**
 * leetcode 922.
 * <p>
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-11-12
 * @since excel-test 1.0.0
 */
public class 按奇偶排序数组 {

    /**
     * 本人
     * <p>
     * 执行用时 2ms     100.00%
     * 内存消耗 39.6MB  93.61%
     * <p>
     * 思路：选奇数或偶数比较，此处选的是偶数，比较若不是偶数，则从奇数位遍历查出偶数，记录此奇数位置，进行交换，以此类推，最后完成
     */
    public int[] sortArrayByParityII(int[] A) {
        int a = 1;
        int tmp;
        int length = A.length;
        for (int index = 0; index < length; index = index + 2) {
            if (A[index] % 2 != 0) {
                while (A[a] % 2 != 0) {
                    a = a + 2;
                }
                tmp = A[index];
                A[index] = A[a];
                A[a] = tmp;
            }
        }

        return A;
    }
}
