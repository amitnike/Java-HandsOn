package com.amit.handson.linkedList;

public class Merge2LinkedLists {

    public ListNode mergeTwoLists(ListNode A, ListNode B) {

        if(A == null){
            return B;
        }

        if(B == null){
            return A;
        }

        ListNode h1 = null;
        ListNode current = null;
        ListNode h2 = null;
        if(A.val > B.val){
            h1 = B;
            current = B;
            h2 = A;
        } else {
            h1 = A;
            current = A;
            h2 = B;
        }

        ListNode temp1 = null;
        ListNode temp2 = null;
        while(h1 != null && h2!= null){
            temp1 = current.next;
            if(temp1 == null ){
                current.next = h2;
                break;
            } else if (h2.val <= temp1.val ){
                //check if linked list2 node value is less than temp1 val (i.e. next element in LL1)
                //or list1 reaches till end
                current.next = h2;
                temp2 = h2.next;
                if(temp1.val >= temp2.val){
                    h2 = temp2;
                    current = temp2;
                } else {
                    h2.next = temp1;
                    current = temp1;
                }
            } else if (h2.val > temp1.val ){
                //check if linked list2 nod{
                //if its greater..keep h2 at is
                current = current.next;
            }
        }
            return  h1;

    }

}
