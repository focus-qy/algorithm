package day02.mergesort;

import java.util.Arrays;

public class RecursionMergeSort {


    public static void mergeSort(int[] arr) {
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int left, int right) {
        if (left == right) return;

        int mid = left + ((right - left) >> 1);

        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, right, mid);
    }

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

    public static void main(String[] args) {
        int arr[] = {5, 7, 8, 1, 3, 6, 0, 2};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}