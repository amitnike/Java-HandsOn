package com.amit.handson.linkedList;

public class FindMiddleNode {

        public int solve(ListNode A) {
            //only 1 node
            if (A == null)  {
                return 0;
            }

            if(A.next == null){
                return A.val;
            } else {
                ListNode temp = A;
                int count = 1;
                //get the count of elements
                while (temp.next != null) {
                    temp = temp.next;
                    count++;
                }
                //move temp to again head
                temp = A;
                for (int i = 1; i <= count / 2; i++) {
                    temp = temp.next;
                }
                return  temp.val;
            }
        }
}
