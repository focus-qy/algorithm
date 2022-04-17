package day02.linklist;

public class SingleLinkList {

  public static class Node{
      private Integer data;
      private Node next;
      public Node(Integer data){
          this.data = data;
      }
  }

    //把链表中的给定值都删除
    public static Node removeElement(Node head,int value){
      while (head != null){
          if(head.data != value) break;
          head = head.next;
      }

//      if(head == null) return null; //方法一：提前初始化前後指針
//      Node cur = head;
//      Node next = head.next;
//      while (next != null){
//          if(next.data == value){
//              cur.next = next.next;
//          }else{
//              cur = next;
//          }
//          next = next.next;
//      }


        Node pre = head; //方法二：在循環中初始化快慢指針
        Node cur = head;
        while (cur != null){
            if (cur.data == value){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
      return head;
    }


  //单链表反转
    public static  Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
    public static void printLinkList(Node head){
      Node node = head;
      while (node != null) {
          System.out.print(node.data + "->");
          node = node.next;
      }
    }

    public static void main(String[] args) {

       Node n1 = new Node(1);
       Node n2 = new Node(2);
       Node n3 = new Node(3);
       Node n4 = new Node(4);
       Node n5 = new Node(5);
       n1.next = n2;
       n2.next = n3;
       n3.next = n4;
       n4.next = n5;
       n5.next = null;

        printLinkList(n1);
        System.out.println();
        printLinkList(removeElement(n1,5));

    }
}
