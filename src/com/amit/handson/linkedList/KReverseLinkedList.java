package com.amit.handson.linkedList;

//Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list
// Input -:
// A = [1, 2, 3, 4, 5, 6]
// B = 2

// Output -:
// [2, 1, 4, 3, 6, 5]
public class KReverseLinkedList {

    public ListNode reverseList(ListNode A, int B) {

        if (A==null){
            return null;
        }

        ListNode prev = null;
        ListNode curr = A;
        int K = B;

        while(curr!= null && B>0){

            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            B--;

        }

        ListNode new_head =  reverseList(curr,K);
        A.next = new_head;
        return  prev;
    }
}
