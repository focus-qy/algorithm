package day02.queue;

import java.util.Stack;

public class TwoStackImplementQueue<E>{


    public  static class MyQueue1<E>{
        private Stack pushStack;
        private Stack popStack;

        public MyQueue1(){
            this.pushStack = new Stack();
            this.popStack = new Stack();
        }


        public E offer(E e){
            while(!popStack.isEmpty()){
                pushStack.push(popStack.pop());
            }
            return (E) pushStack.push(e);
        }

        public E poll(){
            if(popStack.isEmpty()){
                while(!pushStack.isEmpty()){
                    popStack.push(pushStack.pop());
                }
            }
            return (E) popStack.pop();
        }



        public E peek(){
            if(popStack.isEmpty()){
                while(!pushStack.isEmpty()){
                    popStack.push(pushStack.pop());
                }
            }
            return (E) popStack.peek();
        }


        private void swap(){
            Stack temp = pushStack;
            pushStack = popStack;
            popStack = temp;
        }

    }
    public  static class MyQueue2<E>{
        private Stack pushStack;
        private Stack popStack;

        public MyQueue2(){
            this.pushStack = new Stack();
            this.popStack = new Stack();
        }

        private void popAfterPushElement(){
            if(popStack.isEmpty()){
                while (!pushStack.isEmpty()){
                    popStack.push(pushStack.pop());
                }
            }
        }

        public E offer(E e){
            E element =  (E) pushStack.push(e);
            popAfterPushElement();
            return element;
        }

        public E poll(){
            if(pushStack.isEmpty() && popStack.isEmpty()){throw new RuntimeException("queue is empty!");}
            popAfterPushElement();
            return (E) popStack.pop();
        }



        public E peek(){
            if(pushStack.isEmpty() && popStack.isEmpty()){throw new RuntimeException("queue is empty!");}
            popAfterPushElement();
            return (E) popStack.peek();
        }



    }

    public static void main(String[] args) {
        MyQueue1 queue1 = new MyQueue1();
        queue1.offer(1);
        queue1.offer(2);
        queue1.offer(3);
        queue1.offer(4);
        queue1.offer(5);


        System.out.println(queue1.poll());
        System.out.println(queue1.poll());
        System.out.println(queue1.poll());
        System.out.println(queue1.poll());
        System.out.println(queue1.poll());
    }
}
