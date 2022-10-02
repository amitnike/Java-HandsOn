package com.amit.handson.linkedList;

import java.util.List;

//Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.
//
//You should preserve the original relative order of the nodes in each of the two partitions.
public class PartitionLinkedList {
    public ListNode partition(ListNode A, int B) {

        if(A==null || A.next == null){
            return  A;
        }

        //lesser elements
        ListNode start1 = new ListNode(-1);
        ListNode end1 = new ListNode(-1);
        start1.next = end1;
        //equal
        ListNode start2 = new ListNode(-1);
        ListNode end2 = new ListNode(-1);
        start2.next = end2;
        //greater element
        ListNode start3 = new ListNode(-1);
        ListNode end3 = new ListNode(-1);
        start3.next = end3;

        ListNode temp = A;

        while (temp != null){
            if(temp.val < B){
                end1.next = temp;
                end1 = end1.next;
            } else if (temp.val == B) {
                end2.next = temp;
                end2= end2.next;
            } else {
                end3.next = temp;
                end3 = end3.next;
            }
            temp = temp.next;
        }


        return mergeLinkedList(mergeLinkedList(start1.next,start2.next),start3.next);
    }

    private ListNode mergeLinkedList(ListNode A, ListNode B) {
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
