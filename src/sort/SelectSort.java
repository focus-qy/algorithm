package sort;

/**
 * Created by QiYan on 2021/12/21.
 */
public class SelectSort {

    /**
     * 1、时间复杂度 O(n^2)
     * 2、记录下标最后做交换，性能优于冒泡算法
     */
    public void selectSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (i != min) {
                swap(array, i, min);
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
