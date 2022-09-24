package com.amit.handson.linkedList;

public class LinkedList {


    public static int length = 0;
    public static ListNode head = null;

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        if(position > length+1){
            return;
        }

        if(position == 1){
            ListNode node = new ListNode(value);
            node.next = head;
            head = node;
        } else {
            ListNode temp = head;
            for (int i =2;i<=position-1;i++){
                temp = temp.next;
            }
            ListNode node = new ListNode(value);
            node.next = temp.next;
            temp.next = node;
        }
        length++;
    }

    public static void delete_node(int position) {
        // @params position, integer
        if(position > length){
            return;
        }

        if(position == 1){
            head = head.next;
        } else {
            ListNode temp = head;
            for(int i = 2; i <= position - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        length--;


    }

    public static void print_ll() {
        // Output each element followed by a space
        if(length == 0) {
            return;
        }
        ListNode temp = head;
        while(temp.next != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        //print last element
        System.out.print(temp.val);
    }


    public static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
