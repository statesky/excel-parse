package com.sina.算法.八大排序;

import java.util.Arrays;

/**
 * @author zhangbin
 * @version 1.0, 2021-04-19
 * @since excel-test 1.0.0
 */
public class 快速排序 {

    /**
     * 这种方式不太好，比较完成一次之后就分成两部分继续开始比较了
     * 而不是将小于的都放左边，大于的都放右边，再对这两部分进行比较
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        // pivot 中轴值
        int pivot = arr[(left + right) / 2];
        // 临时变量，作为交换时使用
        int tmp = 0;
        // while 循环的目的是让比 pivot 值小的放在左边
        // 比 pivot 大的放在右边
        while (l < r) {
            // 在 pivot 的左边一直找，找到大于等于 pivot 值，才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            // 在 pivot 的右边一直找，找到小于等于 pivot 值，才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            // 如果 l > r，说明 pivot 的左右两部分的值，已经按照左边全部小于，右边全部大于排序了
            if (l >= r) {
                break;
            }

            // 交换
            tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;

            // 如果交换完成后，发现这个 arr[l] == pivot 值，r--，前移
            if (arr[l] == pivot) {
                r -= 1;
            }

            // 如果交换完成后，发现这个 arr[r] == pivot 值， l++，后移
            if (arr[r] == pivot) {
                l += 1;
            }

            // 如果 l == r，必须 l++，r--，否则出现栈溢出
            if (l == r) {
                l++;
                r--;
            }

            // 向左递归
            if (left < r) {
                quickSort(arr, left, r);
            }

            // 向右递归
            if (right > l) {
                quickSort(arr, l, right);
            }
        }
    }


    public static void sort(int a[], int low, int hight) {
        int i, j, index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = a[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && a[j] >= index)
                j--;
            if (i < j)
                a[i++] = a[j];// 用比基准小的记录替换低位记录
            while (i < j && a[i] < index)
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                a[j--] = a[i];
        }
        a[i] = index;// 将基准数值替换回 a[i]
        sort(a, low, i - 1); // 对低子表进行递归排序
        sort(a, i + 1, hight); // 对高子表进行递归排序
    }


    public static void sorts(int[] arr, int begin, int end) {
        if (begin > end) {
            return;
        }
        int i = begin;
        int j = end;
        int index = arr[begin];
        while (i < j) {
            while (i < j && arr[j] >= index) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }
            while (i < j && arr[i] <= index) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }
        }

        arr[i] = index;
        sort(arr, begin, i);
        sort(arr, i, end);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4, 5, 6, -3, 1, 8};
        int[] nums = SortUtils.createNums(10000, 500);
        sorts(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
