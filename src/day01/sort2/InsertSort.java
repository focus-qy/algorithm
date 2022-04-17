package day01.sort2;

/**
 * Created by QiYan on 2021/12/21.
 */
public class InsertSort {

    /**
     * 1、时间复杂度O(n^2)
     * 2、插入排序比选择排序、冒泡排序性能好
     */
    public void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public void swap(int[] array, int i, int j) {
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
        array[i] = array[i] ^ array[j];
        array[j] = array[j] ^ array[i];
        array[i] = array[j] ^ array[i];

    }
}
