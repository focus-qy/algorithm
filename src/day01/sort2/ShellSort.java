package day01.sort2;

/**
 * Created by QiYan on 2021/12/21.
 */
public class ShellSort {
    /**
     * https://www.runoob.com/data-structures/shell-sort.html
     * 1、希尔排序：是对插入排序的优化
     * 2、时间复杂度低于O(n^2)
     * 3、不稳定排序
     * 4、增量选择还是一个数学难题
     */
    public void shellSort(int[] array) {
        int j;
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int tmp = array[i];
                for (j = i; j >= gap && tmp < array[j - gap]; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = tmp;
            }
        }
    }
}
