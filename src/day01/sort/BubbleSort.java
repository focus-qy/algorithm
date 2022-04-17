package day01.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //三种优化：https://blog.csdn.net/fzhhsa/article/details/103113915
    public static  void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2) return; //1.容错
        for (int i = 0; i < arr.length - 1; i++) {//2.总共需要比多少趟
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {//3.每一趟比较次数,优化点如果某一趟没有发生交换则停止排序
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j + 1);
                    flag  = true;
                }
                if(!flag){
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {

        int arr[] = {6,5,4,3,2,1,8};
        bubbleSort(arr);
        System.out.printf(Arrays.toString(arr));
    }
}
