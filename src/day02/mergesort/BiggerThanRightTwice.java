package day02.mergesort;

import java.util.Arrays;

/**
 * 在一个数组中，
 * 对于每个数num，求有多少个后面的数 * 2 依然<num，求总个数
 *
 * ```text
 * 比如：[3,1,7,0,2]
 * 3的后面有：1，0
 * 1的后面有：0
 * 7的后面有：0，2
 * 0的后面没有
 * 2的后面没有
 * 所以总共有5个
 */
public class BiggerThanRightTwice {

    private static int merge(int[] arr, int left, int right, int mid) {
        int pos = mid + 1;
        int answer = 0;
        for (int i = left; i <= mid ; i++) {
            while (pos <= right && arr[i] > 2 * arr[pos]){
                pos++;
            }
            answer += (pos - mid - 1);
        }

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
        return  answer;
    }
    public static int mergeSort(int[] arr){
        int answer = 0;
        int step = 1;
        while (step < arr.length){
            int left = 0;//确定左右边界
            while(left < arr.length){
                int mid = left + step - 1;
                if(mid >= arr.length){
                    break;
                }
                int right = Math.min(mid +step,arr.length -1);
                answer += merge(arr,left,right,mid);
                left = right + 1;
            }

            if(step > arr.length / 2){ // 防止越界
                break;
            }
            step *= 2;
        }
        return answer;
    }
    public static void main(String[] args) {
        int arr[] = {3,1,7,0,2};
        int answer = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(answer);
    }
}
