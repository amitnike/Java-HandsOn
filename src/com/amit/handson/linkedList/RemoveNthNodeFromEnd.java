package com.amit.handson.linkedList;

//Given a linked list A, remove the B-th node from the end of the list and return its head.
//
//For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5.
//
//NOTE: If B is greater than the size of the list, remove the first node of the list.
//
//NOTE: Try doing it using constant additional space.
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        if(A==null || (A.next==null && B>1)){
            return A;
        }

        int count = 0;
        ListNode curr = A;
        ListNode bth = A;
        ListNode prev = null;

        while(curr!=null){
            count++;
            if(count>B){
                prev = bth;
                bth = bth.next;
            }
            curr = curr.next;
        }

        if(prev==null){
            A = bth.next;
        }
        else{
            prev.next = bth.next;
        }

        return A;
    }
}
