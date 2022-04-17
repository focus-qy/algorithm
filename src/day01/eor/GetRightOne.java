package day01.eor;

public class GetRightOne {

    /**
     * 获取二进制最右侧的1
     * @param num
     * @return
     */
    public static int getRightBitOne(int num){
        return num & (~num + 1);
    }


    /**
     * 统计一个数的二进制形式有多少个1
     * @param N
     * @return
     */
    public static int bit1counts(int N) {
        int count = 0;
        while(N != 0) {
            int rightOne = N & ((~N) + 1);
            count++;
            N ^= rightOne;
        }
        return count;
    }

    public static void printBinaryString(int num){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
           sb.append((((num >> i) & 1) == 0) ?  0 : 1);
        }
        System.out.println(sb.reverse());
    }
    public static void main(String[] args) {
//        printBinaryString(getRightBitOne(9));
//        printBinaryString(bit1counts(9));
        System.out.println(bit1counts(15));
    }
}
