package day02.linklist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DoubleLinkedListToStackAndQueue {

    public  class Node<T>{
        private T data;
        private Node<T> pre;
        private Node<T> next;
        public Node(T data){
            this.data = data;
        }
    }
    public  class DoubleQueue<T>{
        private Node<T> head;
        private Node<T> tail;

        public void addElement2Head(T element){
            Node<T> node = new Node<T>(element);
            if(head == null){
                head = node;
                tail = node;
            }else{
                node.next = head;
                head.pre = node;
                head = node;
            }
        }

        public void addElement2Bottom(T element){
            Node<T> node = new Node<T>(element);
            if(head == null){
                head = node;
                tail = node;
            }else{
                tail.next = node;
                node.pre = tail;
                tail = node;
            }
        }


        public T popElementFromHead(){
            if(!isEmpty()){
                Node<T> cur = head;
                if(head == tail){
                    head = null;
                    tail = null;
                }else{
                    head = head.next;
                    cur.next = null;
                    head.pre = null;
                }
                return cur.data;
            }
            return null;
        }
        public T popElementFromBottom(){
            if(!isEmpty()){
                Node<T> cur = tail;
                if(head == tail){
                    head = null;
                    tail = null;
                }else{
                    tail = tail.pre;
                    tail.pre = null;
                    cur.next = null;
                }
            }
            return null;
        }

        public boolean isEmpty(){
            return head == null;
        }

    }
    public  class MyStack<T>{

        private DoubleQueue<T> queue;

        public MyStack(){
            queue = new DoubleQueue<T>();
        }
        public  void push(T element){
            queue.addElement2Head(element);
        }
        public  T pop(){
            return queue.popElementFromHead();
        }
        public T peek(){
            T result = pop();
            push(result);
            return result;
        }
        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
    public  class MyQueue<T>{
        private DoubleQueue<T> queue;

        public MyQueue(){
            queue = new DoubleQueue<T>();
        }

        public void push(T element){
            queue.addElement2Bottom(element);
        }

        public T poll(){
            return queue.popElementFromHead();
        }

        public boolean isEmpty(){
            return queue.isEmpty();
        }
    }

    public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }

    public  class Test{
        public void tes(){

        }
    }


    public static void main(String[] args) {
        DoubleLinkedListToStackAndQueue doubleLinkedListToStackAndQueue = new DoubleLinkedListToStackAndQueue();
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            MyStack<Integer> myStack = doubleLinkedListToStackAndQueue.new MyStack<>();
            MyQueue<Integer> myQueue = doubleLinkedListToStackAndQueue.new MyQueue<>();
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < oneTestDataNum; j++) {
                int nums = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myStack.push(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                    } else {
                        if (!isEqual(myStack.pop(), stack.pop())) {
                            System.out.println("oops!");
                        }
                    }
                }
                int numq = (int) (Math.random() * value);
                if (queue.isEmpty()) {
                    myQueue.push(numq);
                    queue.offer(numq);
                } else {
                    if (Math.random() < 0.5) {
                        myQueue.push(numq);
                        queue.offer(numq);
                    } else {
                        if (!isEqual(myQueue.poll(), queue.poll())) {
                            System.out.println("oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }



}
