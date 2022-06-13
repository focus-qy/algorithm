package test;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> valueStack = new Stack<>();

    public void push(int node) {
        if(minStack.isEmpty()){
            minStack.push(node);
        }else{
           minStack.push(Math.min(minStack.peek(), node));
        }
        valueStack.push(node);
    }

    public void pop() {
        minStack.pop();
        valueStack.pop();
    }

    public int top() {
        return valueStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
