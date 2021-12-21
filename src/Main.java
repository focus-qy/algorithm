import sort.BubbleSort;
import sort.SelectSort;

/**
 * Created by QiYan on 2021/12/21.
 */
public class Main {

    public static void main(String[] args) {
        int array[] = {1, 5, 8, 2, 3, 9, 7, 4, 6};
        new BubbleSort().bubbleSort(array);
        printArray(array, "BubbleSort:");


        int array1[] = {1, 5, 8, 2, 3, 9, 7, 4, 6};
        new SelectSort().selectSort(array1);
        printArray(array1, "SelectSort:");


    }


    public static void printArray(int[] array, String desc) {
        System.out.print(desc);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }
}