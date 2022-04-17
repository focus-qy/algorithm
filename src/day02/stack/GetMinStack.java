package day02.stack;

import java.util.Stack;

public class GetMinStack<T extends Integer> {
    private Stack<T> valueStack;
    private Stack<T> minStack;


    public GetMinStack(){
        valueStack = new Stack<T>();
        minStack = new Stack<T>();
    }


    public void push(T t){
        if( minStack.isEmpty()){
            minStack.push(t);
        }else {
           T minValue = getMinValue();
           if(t.intValue() > minValue.intValue()){
               minStack.push(minValue);
           }else{
               minStack.push(t);
           }
        }
        valueStack.push(t);
    }
    public  T pop(){
        minStack.pop();
        return valueStack.pop();
    }

    public T getMinValue(){
        return minStack.peek();
    }

    public static void main(String[] args) {
        GetMinStack minStack = new GetMinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.push(4);
        minStack.push(5);
        minStack.push(-1);
        minStack.push(6);
        System.out.println(minStack.getMinValue());
    }
}
