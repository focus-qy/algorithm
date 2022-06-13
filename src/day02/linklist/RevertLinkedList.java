package day02.linklist;

import java.util.ArrayList;
import java.util.HashSet;

public class RevertLinkedList {
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }


    public static  ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ListNode curNode = listNode;
        ListNode nextNode = curNode.next;
        curNode.next = null;
        while (nextNode != null){
            ListNode node = nextNode.next;
            nextNode.next = curNode;
            curNode = nextNode;
            nextNode = node;
        }


        while (curNode != null) {
            result.add(curNode.val);
            curNode = curNode.next;
        }


        String s;
//        while (listNode != null) {
//            result.add(listNode.val);
//            listNode = listNode.next;
//        }
//        int size = result.size() / 2;
//        for (int i = 0; i < size; i++) {
//            int index = result.size() - 1 - i;
//            int start = result.get(i);
//            int end = result.get(index);
//
//            result.remove(i);
//            result.add(i, end);
//
//            result.remove(index);
//            result.add(index, start);
//
//        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ArrayList<Integer> integers = printListFromTailToHead(node1);

        System.out.println(integers);
    }
}
