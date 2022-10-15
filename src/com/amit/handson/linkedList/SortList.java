package com.amit.handson.linkedList;


//Sort a linked list, A in O(n log n) time using constant space complexity.

public class SortList {
    public ListNode sortList(ListNode A) {
        //only 1 node or empty
        if (A == null || A.next == null)  {
            return A;
        }
        //head of the  LL1
        ListNode head1 = A;

        //Get the Middle Node
        ListNode middle = getMiddleNode(A);


        //Head of new LL2
        ListNode head2 = middle.next;
        //set the end of old LL as null
        middle.next = null;

        //recursive function to sort both LLs
        head1 = sortList(head1);
        head2 = sortList(head2);

        return mergeLL(head1,head2);
    }

    private static ListNode mergeLL(ListNode head1, ListNode head2) {
        if(head2 == null)
            return head1;

        if(head1 == null)
            return head2;

        ListNode head3 = null;
        ListNode tail = null;

        if(head1.val >= head2.val){
            head3 = head2;
            head2 = head2.next;
        } else {
            head3 = head1;
            head1 = head1.next;
        }
        tail = head3;

        while(head1 != null && head2 != null){
            if (head1.val >= head2.val){
                tail.next = head2;
                head2 = head2.next;
                tail = tail.next;
            } else {
                tail.next = head1;
                head1 = head1.next;
                tail = tail.next;
            }
        }

        if (head1!= null)
            tail.next = head1;

        if (head2!= null)
            tail.next = head2;

        return head3;
    }

    private static ListNode getMiddleNode(ListNode A) {
        //find the middle
        ListNode slow = A;
        ListNode fast = A;

        ListNode middle = null;

        while(fast.next != null  && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        middle = slow;
        return  middle;
    }
}
