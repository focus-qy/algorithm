package day02.mergesort;

import java.util.Arrays;

public class IteratorMergeSort {

    private static void merge(int[] arr, int left, int right, int mid) {
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int index = 0;
        while (p1 <= mid && p2 <= right) {
            help[index++] = (arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++]);
        }

        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }

        while (p2 <= right) {
            help[index++] = arr[p2++];
        }

        for (int i = 0; i < right - left + 1; i++) {
            arr[left + i] = help[i];
        }
    }
    public static void mergeSort(int[] arr){
        int step = 1;
        while (step < arr.length){
            int left = 0;//确定左右边界
            while(left < arr.length){
                int mid = left + step - 1;
                if(mid >= arr.length){
                    break;
                }
                int right = Math.min(mid +step,arr.length -1);
                merge(arr,left,right,mid);
                left = right + 1;
            }

            if(step > arr.length / 2){ // 防止越界
               break;
            }
            step *= 2;
        }

    }
    public static void main(String[] args) {
        int arr[] = {5, 7, 8, 1, 3, 6, 0, 2};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
