package day02.recursion;

public class GetMaxValue {

    public static int getMaxValue(int[] arr){
        return process(arr,0,arr.length - 1);
    }

    public static int process(int[] arr, int left, int right){
        if(right - left <= 1) return Math.max(arr[left],arr[right]);
        int mid = left + ((right - left) >> 1);
        int leftMax = process(arr,left,mid  - 1);
        int rightMax = process(arr,mid,right);
        return Math.max(leftMax,rightMax);
    }

    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,6,7};
        System.out.println(getMaxValue(arr));
    }
}
