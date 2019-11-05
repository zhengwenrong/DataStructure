package org.wenrong.leetcode;

public class LeetCodeNum2 {

    public static void main(String[] args) {

        System.out.println(807%10);

        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);

//        node1.next = node2;
//        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
//        node4.next = node5;
//        node5.next = node6;

        addTwoNumbers(node1,node4);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode headNode = null;

        int plus = 0;

        while(l1 != null && l2 != null){

            int sum = l1.val + l2.val;

            if(sum >= 10){
                plus = 1;
                sum = sum-10;
            }

            if(headNode == null){

                headNode = new ListNode(sum);

            }else {

                ListNode lastNode = headNode;
                while(lastNode.next != null){

                    lastNode = lastNode.next;
                }

                ListNode newNode = null;

                if(plus ==1 ){
                    plus = plus + 1;
                    newNode = new ListNode(sum);
                }else if(plus == 2){
                    newNode = new ListNode(sum + 1);
                    plus = 0;
                }else{
                    newNode = new ListNode(sum);
                }

                lastNode.next = newNode;

            }

            l1 = l1.next;
            l2 = l2.next;

        }

        //有1的情况补1
        if(plus == 1){

            ListNode lastNode = headNode;
            while(lastNode.next != null){

                lastNode = lastNode.next;
            }

            ListNode newNode = null;

            newNode = new ListNode(1);
            lastNode.next = newNode;

        }

        return headNode;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}