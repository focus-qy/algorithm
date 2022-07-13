package test;

public class MyLinkedList {
    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    private void removeNode(Node head, int step) {
        if (head == null) {
            return;
        }

        Node slow = head;
        Node fast = head;

        int num = 0;
        while (fast != null) {
            num++;
            fast = fast.next;
            if (num == step) {
                break;
            }
        }

        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        if(slow.next != null){
           slow.next = slow.next.next;
        }

    }



    //aabbaaa a2b2a3




}
