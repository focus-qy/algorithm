package day01.find;

public class BinarySearch {
    /**
     * 有序數組查找小于等于某个数最右侧下标
     * @param arr
     * @param num
     * @return
     */
    public static int nearestRightIndex(int[] arr,int num){
        if(arr == null || arr.length == 0) return  -1;
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while(left <= right){//注意>>運算符優先級
            int mid = left + ((right - left) >> 1);
            if(arr[mid] <= num){
                left = mid + 1;
                index = mid;
            }else{
                right = mid - 1;
            }
        }
        return  index;
    }
    /**
     * 有序數組查找大于等于某个数最左侧下标
     * @param arr
     * @param num
     * @return
     */
    public static int nearestLeftIndex(int[] arr,int num){
        if(arr == null || arr.length == 0) return  -1;
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while(left <= right){//注意>>運算符優先級
            int mid = left + ((right - left) >> 1);
            if(arr[mid] >= num){
                right = mid - 1;
                index = mid;
            }else{
                left = mid + 1;
            }
        }
        return  index;
    }

    /**
     * 有序數組查找某個數是否存在
     * @param arr
     * @param num
     * @return
     */
    public static int binarySearch(int[] arr,int num){
        if(arr == null || arr.length == 0) return  -1;
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){//注意>>運算符優先級
            int mid = left + ((right - left) >> 1);
            if(arr[mid] > num){
                right = mid - 1;
            }else if(arr[mid] < num){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
//        System.out.println(binarySearch(arr,7));
//        System.out.println(nearestLeftIndex(arr,3));
        System.out.println(nearestRightIndex(arr,3));
    }
}
