package day02.mergesort;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。可以利用归并排序, 在merge的时候,统计逆序对个数。
 *
 * 在一个数组中，任何一个前面的数a，和任何一个后面的数b，如果(a,b)是降序的，就称为逆序对, 返回数组中所有的逆序对
 */
public class InversionNumber {

    public static int  merge(int[] arr,int left,int right,int mid){
        int[] help = new int[right - left + 1];
        int p1 = mid;
        int p2 = right;
        int index = right - left;
        int answer = 0;
        while (p1 >= left && p2 > mid){
            answer += (arr[p1] > arr[p2] ? ((p2 - mid)):  0);
            help[index--] = (arr[p1] >= arr[p2] ? arr[p1--] : arr[p2--]);
        }

        while (p1 >= left){
            help[index--] =  arr[p1--];
        }

        while (p2 > mid){
            help[index--] =  arr[p2--];
        }

        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
        return  answer;
    }

    public static int mergeSort(int[] arr){
        int len  = arr.length;
        int step = 1;
        int result = 0;
        while (step < len){
            int left = 0;
            while (left < len){
                int mid = left + step - 1;
                if(mid >= len ){
                    break;
                }
                int right = Math.min(mid + step,len - 1);
                result += merge(arr,left,right,mid);
                left = right + 1;
            }
            if(step > len / 2){
                break;
            }
            step <<= 1;
        }
        return result;

    }
    public static void main(String[] args) {
        int arr[] = {1,3,4,2,5};

        System.out.println( mergeSort(arr));
        System.out.println(Arrays.toString(arr));
    }
}
