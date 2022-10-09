package com.amit.handson.linkedList;

import java.util.HashMap;

public class LRU {
    public static DoublyListNode head = new DoublyListNode(-1,-1);
    public static DoublyListNode tail = new DoublyListNode(-1,-1);
    public HashMap<Integer,DoublyListNode> map = new HashMap<Integer,DoublyListNode>();
    public int capacity ;

    public LRU(int capacity) {
            this.capacity = capacity;
            head.next=tail;
            tail.prev=head;
    }

    public int get(int key) {
        //check if value is present in LL
        //If present return it else return -1
        int out = -1;

        if(map.containsKey(key)){
            DoublyListNode node =  map.get(key);
            //return element
            out = node.val;
            //delete the node and set it at tail
            deleteNode(node);
            // insert the node at the back again to make it recently used
            insertAtTail(node);
        }
        return  out;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)){
            DoublyListNode node = map.get(key);
            node.val = value;
            // remove the node from current location
            deleteNode(node);
            // insert the node at the back again to make it recently used
            insertAtTail(node);
        } else {
            //before add check the capacity..if reaches capacity, remove from head.next
            if(map.size() == capacity){
                //remove from head
                DoublyListNode LRU = head.next;
                deleteNode(LRU);
                map.remove(LRU.key);
            }
            //create new Node if not present
            DoublyListNode x = new DoublyListNode(key,value);
            //insert at tail
            insertAtTail(x);
            //put into map
            map.put(key,x);
        }
    }

    private void moveToFront(DoublyListNode y) {
        deleteNode(y);
        insertAtTail(y);
    }

    private void deleteNode(DoublyListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    private void insertAtTail(DoublyListNode node) {
        node.next = tail;
        node.prev = tail.prev;

        node.prev.next = node;
        tail.prev = node;
    }
}
