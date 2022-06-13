package tree;

public class HeapSort {


    private void heapIfy(int[] arr,int index,int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize){
            int maxValueIndex = left + 1 < heapSize && arr[left  + 1] > arr[left] ? left + 1 : left;
            maxValueIndex = arr[index] > arr[maxValueIndex] ? index : maxValueIndex;
            if(index == maxValueIndex){
                break;
            }
            swap(arr,index,maxValueIndex);
            index = maxValueIndex;
            left = index * 2 + 1;
        }
    }

    //2 * i + 1 、 2 * i + 2 、  (i - 1)/2
    private void heapInsert(int[] arr, int index) {
        int parentIndex = -1;
        while (arr[index] > arr[parentIndex = (index - 1) / 2]) {
            swap(arr,index,parentIndex);
            index = parentIndex;
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private void heapSort(int[] arr) {

//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr,i);
//        }

        for (int i = arr.length - 1; i >= 0; i--) {
            heapIfy(arr, i, arr.length);
        }

        int heapSize = arr.length;
        for (int i = arr.length - 1; i >= 0 ; i--) {
            swap(arr,0,i);
            heapIfy(arr,0,--heapSize);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,3,1,2,7,4,5,0,8,9};
        new HeapSort().heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + ",");
        }
    }
}
