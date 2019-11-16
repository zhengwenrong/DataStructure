package org.wenrong.linked;

/**
 * 环形单链表实现
 */
public class CurcleLinkedList {

    private Node headNode = new Node();

    private Node currentNode;

    private void add(int data){

        Node lastNode = lastNode();
        Node node = new Node(data);
        lastNode.next = node;
        node.next = headNode;


    }

    @Override
    public String toString() {

        Node node = headNode.next;

        StringBuffer buffer = new StringBuffer();
        buffer.append("[");

        while(node != null && node.data != null){

            buffer.append(node.data);
            buffer.append(",");
            node = node.next;
        }
        buffer.append("]");
        String string = buffer.toString();


        return string.substring(0,string.lastIndexOf(",")) + "]";
    }

    private Node lastNode(){

        Node lastNode = headNode;

        while (lastNode.next != null && lastNode.next.data != null) {
            lastNode = lastNode.next;
        }

        return lastNode;
    }

    private Node getNodeAt(int index){

        Node node = headNode;

        int i = -1;

        while (node.next!=null && node.next.data != null) {

            if(i == index){

                return node;
            }

            node = node.next;
            i++;
        }

        return null;
    }

    private int remove(int index){

        Node nodeAt = getNodeAt(index);

        return 0;
    }

    public static void main(String[] args) {

        CurcleLinkedList list = new CurcleLinkedList();

        for(int i = 0 ; i < 1000; i++){

            list.add(i);

        }

        System.out.println(list.getNodeAt(0));
    }

    class Node {

        public Node next;
        public Integer data;

        public Node(){}

        public Node(int data){

            this.data= data;

        }

        public Node(Node next, int data){
            this.next = next;
            this.data = data;
        }

        @Override
        public String toString() {
            return this.data+ "";
        }
    }

}
