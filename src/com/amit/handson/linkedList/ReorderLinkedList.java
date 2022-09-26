package com.amit.handson.linkedList;

//Given a singly linked list A
//
// A: A0 → A1 → … → An-1 → An
//reorder it to:
//
// A0 → An → A1 → An-1 → A2 → An-2 → …
//You must do this in-place without altering the nodes' values.

public class ReorderLinkedList {
    public ListNode reorderList(ListNode A) {
        //only 1 node
        if (A.next == null)  {
            return A;
        }
        //head of the first LL
        ListNode head1 = A;

        //find the middle
        ListNode slow = A;
        ListNode fast = A;

        ListNode middle = null;

        while(fast.next != null  && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        middle = slow;

        //Head of new LL
        ListNode head2 = middle.next;
        //set the end of old LL as null
        middle.next = null;

        //reverse the second LL and return head
        head2 = reverseLinkedList(head2);

        //start merging both LLs
        ListNode current = head1;
        ListNode temp1 = null;
        ListNode temp2 = null;
        while (head2 != null){
            temp1 = current.next;
            current.next = head2;
            temp2 = head2.next;
            head2.next = temp1;
            head2 = temp2;
            current = temp1;
        }

        return  head1;
    }

    private ListNode reverseLinkedList(ListNode temp2) {
        ListNode prev = null;
        ListNode curr = temp2;

        while (curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        temp2 = prev;
        return  temp2;
    }
}
