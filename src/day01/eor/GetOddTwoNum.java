package day01.eor;

/**
 * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
 * 思路：
 * 1.使用异或获取获取两种数，假设结果为 result
 * 2.提取result最右侧p位置的1用eor表示，该1说明两种数在p位置二进制表示不同
 * 3.数组所有元素可分为两类：一类p位置二进制数为0，一类二进制数为1
 * 4.用数组中所有元素与eor异或结果不为1，得一奇数元素 oddElement
 * 5.用oddElement与result异或，得另一奇数元素anotherElement
 */
public class GetOddTwoNum {

    public static void  printTwoOddNum(int[] arr){
        int result = 0;
        for (int i = 0; i <arr.length ; i++) {
            result ^= arr[i];
        }

        int eor = result & (-result);
        int another = 0;
        for (int i = 0; i < arr.length; i++) {
            if((arr[i] & eor) != 0){
                 another ^= arr[i];
            }
        }

        System.out.println(another +" " +(result ^ another));
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,8,1,2,3};

        printTwoOddNum(arr);
    }
}
