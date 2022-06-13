package day02.stack;

import java.util.ArrayList;
import java.util.LinkedList;

public class MaxInWindows {

    public ArrayList<Integer> maxInWindows1(int[] num, int size) {
        if (num == null || num.length < size) return null;
        ArrayList<Integer> result = new ArrayList<>();
        int end = 0;
        for (int i = 0; end <= num.length; i++) {
            end = i + size;
            int maxNumIndex = i;
            for (int j = i; j < end; j++) {
                if (num[j] > num[maxNumIndex]) {
                    maxNumIndex = j;
                }
            }
            result.add(num[maxNumIndex]);
            end++;
        }
        return result;
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num == null || num.length < size) return null;
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int R = 0; R < num.length; R++) {
            while (!queue.isEmpty() && num[R] >= num[queue.peekLast()]){
                queue.pollLast();
            }
            queue.addLast(R);
            if(queue.peekFirst() == R - size){
                queue.pollFirst();
            }
            if (R >= size - 1) {
                result.add(num[queue.peekFirst()]);
            }
        }
        return result;
    }

}
