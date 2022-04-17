package day01.sort;

import java.util.Arrays;

public class SelectSort {

        public static void swap(int[] arr,int i,int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public static  void selectSort(int[] arr){
            if(arr == null || arr.length < 2) return; //1.容错
            for (int i = 0; i < arr.length - 1; i++) {//2.每次选择一个基准数
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {//3.与基准数做比较，优化点不需要每次都做交换
                   minIndex =  arr[i] > arr[j] ? j : minIndex;
                }
                if (i != minIndex) {
                    swap(arr,i,minIndex);
                }
            }
        }

        public static void main(String[] args) {
            int arr[] = {6,5,4,3,2,1,8};
            selectSort(arr);
            System.out.printf(Arrays.toString(arr));
        }


}
