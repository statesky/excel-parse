package com.sina.算法.八大排序;

import java.util.Arrays;

/**
 * @author zhangbin
 * @version 1.0, 2021-04-19
 * @since excel-test 1.0.0
 */
public class 归并排序 {

    /**
     * 合并
     * 前面合并至tmp数组中，后面进行赋值
     */
    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + low] = temp[k2];
        }
    }

    /**
     * 整个流程其实很简单
     * 首先是分的过程，不断的分，直至分到只剩下一个为止，但此时进入的时候，low == high，所以直接到达上层，即两个时候
     * 此时，mid左边和右边分别是有序的，调用merge方法，进行合并
     */
    public static void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            mergeSort(a, low, mid);
            // 右边
            mergeSort(a, mid + 1, high);
            // 左右归并
            merge(a, low, mid, high);
        }
    }


    public static void main(String[] args) {
        //int[] a = new int[]{3, 2, 5, 4, 6, 8, 7, 1};
        int[] a = SortUtils.createNums(1000, 200);
        mergeSort(a, 0, a.length - 1);

        System.out.println(Arrays.toString(a));
    }
}
