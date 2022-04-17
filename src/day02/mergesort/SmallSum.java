package day02.mergesort;

import java.util.Arrays;

/**
 * 在一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫数组小和。求数组小和。
 * 例子： [1,3,4,2,5]
 * 1左边比1小的数：没有
 * 3左边比3小的数：1
 * 4左边比4小的数：1、3
 * 2左边比2小的数：1
 * 5左边比5小的数：1、3、4、 2
 * 所以数组的小和为1+1+3+1+1+3+4+2=16
 */
public class SmallSum {

    public static int  merge(int[] arr,int left,int right,int mid){
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int index = 0;
        int answer = 0;
        while (p1 <= mid && p2 <= right){
            answer += (arr[p1] < arr[p2] ? (arr[p1] *(right - p2 + 1)):  0);
            help[index++] = (arr[p1] < arr[p2] ? arr[p1++] : arr[p2++]);
        }

        while (p1 <= mid){
            help[index++] =  arr[p1++];
        }

        while (p2 <= right){
            help[index++] =  arr[p2++];
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
        System.out.println(mergeSort(arr));
    }

}
