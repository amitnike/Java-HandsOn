package com.amit.handson.linkedList;

//Given a singly linked list, delete middle of the linked list.
//
//For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5
//
//If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.
//
//For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.
//
//Return the head of the linked list after removing the middle node.
//
//If the input linked list has 1 node, then this node should be deleted and a null node should be returned.

public class DeleteMiddleNode {
    public ListNode solve(ListNode A) {
        if(A==null || A.next == null){
            return null;
        } else {
            ListNode temp = A;
            int count = 1;
            //get the count of elements
            while(temp.next != null){
                temp = temp.next;
                count++;
            }

            //move temp to head
            temp = A;
            for (int i=1;i< count/2;i++){
                temp = temp.next;
            }
            ListNode node = temp.next.next;
            temp.next = node;
        }
        return  A;
    }
}
