package day02.linklist;

public class DoubleLinkedList {
    public static class Node{
        private Integer data;
        private Node pre;
        private Node next;
        public Node(Integer data){
            this.data = data;
        }
    }

    public static void printDoubleLinkList(Node head){
        Node node = head;
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
    }
    public static Node reverseDoubleLinkedList(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.pre = next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.pre = null;
        n1.next = n2;

        n2.pre = n1;
        n2.next = n3;

        n3.pre = n2;
        n3.next = n4;

        n4.pre = n3;
        n4.next = n5;

        n5.pre = n4;
        n5.next = null;

        printDoubleLinkList(n1);
        System.out.println();
        printDoubleLinkList(reverseDoubleLinkedList(n1));

    }
}
