package day02.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TwoQueueImplementStack {

    public static class MyStack<E>{
        private Queue pushQueue;
        private Queue popQueue;
        private int size;
        public MyStack(){
            pushQueue = new LinkedList<E>();
            popQueue = new LinkedList<E>();
        }


        private void swap(){
            Queue temp = pushQueue;
            pushQueue = popQueue;
            popQueue = temp;
        }

        //優化版本
        public boolean push(E e){
            return pushQueue.offer(e);
        }

        public E pop(){
            while (pushQueue.size()  > 1)  {
                popQueue.offer(pushQueue.poll());
            }
            E e = (E) pushQueue.poll();
            swap();
            return e;
        }

        public E peek(){
            while (pushQueue.size() > 1)  {
                popQueue.offer(pushQueue.poll());
            }
            E e = (E) pushQueue.poll();
            popQueue.offer(e);
            swap();
            return e;
        }

//        public boolean push(E e){
//            size++;
//            return pushQueue.offer(e);
//
//        }
//
//        public E pop(){
//            if(pushQueue.isEmpty()){throw new RuntimeException("stack is empty!");}
//            E e = null;
//            int count = 0;
//            while(!pushQueue.isEmpty()){
//                e = (E) pushQueue.poll();
//                count++;
//                if(count != size){
//                    popQueue.offer(e);
//                }
//            }
//            swap();
//            size--;
//            return  e;
//        }
//
//        public E peek(){
//            if(pushQueue.isEmpty()){throw new RuntimeException("stack is empty!");}
//            E e = null;
//            while(!pushQueue.isEmpty()){
//                e = (E) pushQueue.poll();
//                popQueue.offer(e);
//            }
//            swap();
//            return (E) e;
//        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
