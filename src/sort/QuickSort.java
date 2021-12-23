package sort;

import java.util.Arrays;

/**
 * Created by QiYan on 2021/12/22.
 */
public class QuickSort {

    public void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }


    public void quick(int[] array, int low, int height) {
        if (low >= height) {
            return;
        }
//        System.out.println(Arrays.toString(array));
        int pv = partition2(array, low, height);
        quick(array, low, pv - 1);
        quick(array, pv + 1, height);
    }


    /***
     * 单边循环
     */
    public int partition(int[] array, int low, int height) {
        int pv = array[height];//基准点
        int i = low;
        for (int j = low; j < height; j++) {
            if (array[j] < pv) {
                if (i != j) {
                    swap(array, i, j);
                }
                i++;
            }
        }

        if (i != height) {
            swap(array, i, height);
        }
        return i;
    }

    /***
     * 双边循环
     */
    public int partition2(int[] array, int low, int height) {
        int pv = array[low];//基准点
        int i = low;
        int j = height;
        while (i < j) {
            //从右向左找比基准点小的元素
            while (i < j && array[j] > pv) {
                j--;
            }
            //从左向右找比基准点大的元素
            while (i < j && array[i] <= pv) {
                i++;
            }
            //交换
            swap(array, i, j);
        }
        swap(array, low, i);
        return i;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        int array[] = {1, 5, 2, 3, 7, 4, 6, 0, 9, 10, 8};
        new QuickSort().quickSort(array);
        System.out.println(Arrays.toString(array));
    }

}
