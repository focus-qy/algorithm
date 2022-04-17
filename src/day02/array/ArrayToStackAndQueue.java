package day02.array;

public class ArrayToStackAndQueue {

    public class MyStack<T>{
        private int maxSize = 100;
        private T[] array;
        private int size;

        public MyStack(){
            array = (T[]) new Object[maxSize];
        }
        public MyStack(int limit){
            maxSize = limit;
            array = (T[]) new Object[maxSize];
        }

        public void push(T element) {
            if(isFull()){
                throw new RuntimeException("stack is full...");
            }
            array[size++] = element;
        }


        public T pop() {
            if (isEmpty()){
                throw new RuntimeException("stack is empty...");
            }
            return array[--size];
        }

        public boolean isFull(){
            return size == maxSize;
        }

        public boolean isEmpty(){
            return size == 0;
        }
    }

    public class MyQueue<T>{
        private  int maxSize = 10;
        private T[] array;
        private int begin;
        private int end;
        private int size;

        public MyQueue(){
            array = (T[]) new Object[maxSize];
        }
        public MyQueue(int limit){
            maxSize = limit;
            array = (T[]) new Object[maxSize];
        }

        public void push(T element) {
            if (isFull()) throw  new RuntimeException("queue is full...");
            array[begin] = element;
            begin = (begin+1) % (maxSize - 1);
            size++;
        }


        public T pop(){
            if (isEmpty()) throw  new RuntimeException("queue is empty...");
            T element = array[end];
            end = (end+1) % (maxSize - 1);
            size--;
            return element;
        }


        public boolean isEmpty(){
            return size == 0;
        }

        public boolean isFull(){
            return size == maxSize;
        }


    }


    public static void main(String[] args) {
//        MyQueue queue = new ArrayToStackAndQueue().new  MyQueue<Integer>();
//        queue.push(1);
//        queue.push(2);
//        queue.push(3);
//        queue.push(4);
//        queue.push(5);
////        System.out.println(queue.pop());
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());


        MyStack stack =  new ArrayToStackAndQueue().new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
