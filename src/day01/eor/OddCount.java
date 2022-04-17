package day01.eor;

/**
 * 一个数组中出现了奇数次的数
 */
public class OddCount {
    public static int findOddNum(int[] arr) {
//        if(arr == null || arr.length == 0){ throw new Exception("error!");}
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result ^= arr[i];
        }
        return  result;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3,5,6,7,5,6,3};
        System.out.println(findOddNum(arr));
    }
}
