package org.wenrong.linked;

/**
 * 环形单链表实现
 */
public class CurcleLinkedList {

    private Node headNode;












    public static void main(String[] args) {

    }

    class Node {

        public org.wenrong.linked.Node next;
        public int data;

        public Node(){}

        public Node(org.wenrong.linked.Node next, int data){
            this.next = next;
            this.data = data;
        }

    }


}
