package com.amit.handson.linkedList;

public class RemoveLoop_LL {

    public ListNode solve(ListNode A) {

        if (A.next == null){
            return A;
        }

        ListNode slow = A;
        ListNode fast = A;
        boolean loopExists = false;

        //this loop check if loop exists or not
        while(slow.next != null && (fast.next != null && fast.next.next != null)){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                loopExists = true;
                break;
            }
        }

        if(!loopExists){
            return A;
        }

        slow = A;
        ListNode temp = null;
        while (slow != fast){
            slow = slow.next;
            temp = fast;
            fast = fast.next;
        }

        temp.next = null;
        return  A;

    }

}
