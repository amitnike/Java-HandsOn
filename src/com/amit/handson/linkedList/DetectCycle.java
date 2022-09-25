package com.amit.handson.linkedList;

public class DetectCycle {
        public ListNode detectCycle(ListNode a) {

            if (a.next == null){
                return null;
            }

            ListNode slow = a;
            ListNode fast = a;
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
                return null;
            }

            //if exists...lets find where it began
            slow = a;
            while (slow != fast){
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
    }
}
