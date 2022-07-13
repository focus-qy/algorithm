package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintBinaryTree {
     static class Node {
        int value;
        Node left ;
        Node right;

        public Node(int value) {
            this.value = value;

        }
    }
  public static  ArrayList<ArrayList<Integer>> printTree(Node root) {
        ArrayList<ArrayList<Integer> > result = new  ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        
        Queue<Node> queue = new LinkedList<Node>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        queue.add(root);
        temp.add(root.value);
        
        Node curHead = root;
        Node curEnd = root;
        Node nextEnd = null;
       
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(curHead == node){
                 result.add(new ArrayList<Integer>(temp));
                 temp.clear();
            }
            if(node.left != null){
                queue.add(node.left);
                temp.add(node.left.value);
                nextEnd = node.left;
            }
            if(node.right != null){
                queue.add(node.right);
                temp.add(node.right.value);
                nextEnd = node.right;
            }
            
            if(curEnd == node){
                curEnd = nextEnd;
                curHead = queue.peek();
            }
            
        }
        return result;
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        ArrayList<ArrayList<Integer>> lists = printTree(node1);
        for (ArrayList<Integer> list:lists) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                System.out.printf(""+list.get(i));
                if(i != size -1){
                    System.out.printf(",");
                }
            }
            System.out.println();
        }



    }
    
}