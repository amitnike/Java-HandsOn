package com.amit.handson.linkedList;

//You are given a singly linked list having head node A. You have to reverse the linked list and return the head node of that reversed list.
//
//NOTE: You have to do it in-place and in one-pass.
public class ReverseLinkedList {
    public ListNode reverseList(ListNode A) {
        //set curr as current head
        ListNode curr = A;
        //set prev node to null
        ListNode prev = null;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        A = prev;
        return  A;
    }
}
