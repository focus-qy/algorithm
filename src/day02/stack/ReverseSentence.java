package day02.stack;

import java.util.Stack;

public class ReverseSentence {

    public String ReverseSentence(String str) {
        if(str == null || str.length() < 2) return str;
        String[] strings = str.split(" ");

        Stack<String> stack = new Stack();
        for (String s: strings) {
            stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
            sb.append(" ");
        }
        return sb.substring(0,sb.length() - 1);
    }

    public static void main(String[] args) {

    }
}
