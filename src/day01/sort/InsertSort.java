package day01.sort;

import java.util.Arrays;

public class InsertSort {

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //扑克牌插入
    public static  void insertSort(int[] arr){
        if(arr == null || arr.length < 2) return; //1.容错
        for (int i = 0; i < arr.length - 1; i++) {//2.越界检测
            for (int j = i + 1; j > 0; j--) {
                if(arr[j-1] > arr[j]){//3.交换元素
                    swap(arr,j-1,j);
                }
            }
        }
    }


    public static void main(String[] args) {

        int arr[] = {6,5,4,3,2,1,8};
        insertSort(arr);
        System.out.printf(Arrays.toString(arr));
    }
}
