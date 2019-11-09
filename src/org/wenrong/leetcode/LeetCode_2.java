package org.wenrong.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_2 {

    public static void main(String[] args) {

//        System.out.println(807%10);
//
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);

//       node1.next = node2;
//       node2.next = node3;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
//        node4.next = node5;
//        node5.next = node6;

       addTwoNumbers(node1,node4);

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        /**
         * 使用两个List来装数据
         */
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        ListNode headNode = null;

        /**
         * 使用遍历来将链表中的数据存到List中
         */
        while(!(l1 == null && l2 == null)){

            if(l1 != null){
                list1.add(l1.val);
            }

            if(l2 != null){

                list2.add(l2.val);
            }
            if(l1!=null){
                l1 = l1.next;
            }

            if(l2!=null){
                l2 = l2.next;
            }

        }

        int i = 0;

        /**
         * 遍历两个List
         */
        while (!(list1.size()-1 < i&&list2.size()-1 < i)){

            int num1 = 0;
            int num2 = 0;

            if(list1.size()-1 >= i)
                num1 = list1.get(i);

            if(list2.size()-1 >= i)
                num2 = list2.get(i);

            int num3 = num1 + num2;

            /**
             * 对大于10的情况处理
             */
            if(num3 >= 10){
                int popFromStack1 = 0;
                 if(list1.size()-1 > i) {
                     popFromStack1 = list1.get(i+1);
                     list1.remove(i+1);
                     list1.add(i+1,popFromStack1 + 1);
                 }else if(list1.size()-1 == i){
                     list1.add(i+1,popFromStack1 + 1);
                 } else if (list2.size()-1 > i) {
                     popFromStack1 = list2.get(i+1);
                     list2.remove(i+1);
                     list2.add(i+1,popFromStack1 + 1);
                 }else if(list2.size()-1 == i){
                     list1.add(i+1,popFromStack1 + 1);
                 }

                num3 = num3 - 10;
            }

            if(headNode == null){

                headNode = new ListNode(num3);

            }else {

                ListNode lastNode = headNode;

                while(lastNode.next != null){

                    lastNode = lastNode.next;

                }

                ListNode newNode = new ListNode(num3);
                lastNode.next = newNode;
            }

            i++;

        }

        return headNode;

    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}