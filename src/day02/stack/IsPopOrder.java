package day02.stack;

import java.util.Stack;

public class IsPopOrder {
    private static Stack<Integer> stack = new Stack<>();

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) return false;
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            int popValue = popA[popIndex];
            int value =  stack.peek();
            while (value == popValue){
                stack.pop();
                ++popIndex;
                if(!stack.isEmpty()){
                    value = stack.peek();
                    popValue = popA[popIndex];
                }else {
                    break;
                }
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
       int pushA[] = {2,1,0};
       int popA[] =  {1,2,0};
        System.out.println(IsPopOrder(pushA,popA));
    }
}
