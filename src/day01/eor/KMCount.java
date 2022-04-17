package day01.eor;

/**
 * 一个数组中有一种数出现K次，其他数都出现了M次，
 * M > 1,  K < M
 * 找到，出现了K次的数，
 * 要求，额外空间复杂度O(1)，时间复杂度O(N)
 */

public class KMCount {

    public static int getKTimesNum(int[] arr,int k,int m){
        int result  = 0;
        int[] bits = new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                bits[i] +=((num >> i) & 1);
            }
        }
        for (int i = 0; i < 32; i++) {
//            if(bits[i] % m != 0){
//                result |= ((1 << i));
//            }

            if(bits[i] % m == 0){
                continue;
            }

            if(bits[i] % m == k){
                result |= (1 << i);
            }else{
                return  -1;
            }
        }
        if(result == 0){
            int count  = 0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] == 0){
                    count ++;
                }
            }
            if(count != k){
                return -1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,2,6,6,6,0,0,0,9,9};
        int k = 2;
        int m = 3;
        System.out.println(getKTimesNum(arr,k,m));
    }
}
