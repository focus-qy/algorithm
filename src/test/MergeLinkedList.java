package test;

public class MergeLinkedList {

    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    public static Node merge(Node head1, Node head2) {
//        if (head1 == null && head2 != null) return head2;
//        if (head2 == null && head1 != null) return head1;

        Node cur1 = head1;
        Node cur2 = head2;
        Node newHead = null;
        Node newCur = null;

        Node tempNode = null;
        while (cur1 != null && cur2 != null) {

            if (cur1.value <= cur2.value) {
                tempNode = new Node(cur1.value);
                cur1 = cur1.next;
            } else {
                tempNode = new Node(cur2.value);
                cur2 = cur2.next;
            }
            if (newHead == null) {
                newHead = newCur = tempNode;
            }else{
                newCur.next = tempNode;
                newCur = tempNode;
            }
        }

        while (cur1 != null){
            tempNode = new Node(cur1.value);
            newCur.next = tempNode;
            newCur = tempNode;
            cur1 = cur1.next;
        }

        while (cur2 != null){
            tempNode = new Node(cur2.value);
            newCur.next = tempNode;
            newCur = tempNode;
            cur2 = cur2.next;
        }


        return newHead;
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        Node node9 = new Node(9);
        node1.next = node3;
        node3.next = node5;
        node5.next = node7;
        node7.next = node9;




        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node6 = new Node(6);
        Node node8 = new Node(8);

        node2.next = node4;
        node4.next = node6;
        node6.next = node8;


      Node  node = merge(node1,node2);

      while (node!= null){
          System.out.printf(node.value  + " ->");
          node = node.next;
      }
    }

}
