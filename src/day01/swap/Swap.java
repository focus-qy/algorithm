package day01.swap;

import java.util.Arrays;

public class Swap {


    public static void swap(int[] arr,int i,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

    }


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        swap(arr,0,4);
        System.out.println(Arrays.toString(arr));
    }
}
