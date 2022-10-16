package com.amit.handson.adv_trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//You are given an integer array A denoting the Level Order Traversal of the Binary Tree.
//
//You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.
//
//NOTE:
//
//In the array, the NULL/None child is denoted by -1.
//For more clarification check the Example Input.
//Input 1:
//
// A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
//Input 2:
//
// A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
//
//
//Example Output
//Output 1:
//
//           1
//         /   \
//        2     3
//       / \
//      4   5
//Output 2:
//
//            1
//          /   \
//         2     3
//        / \ .   \
//       4   5 .   6
public class DeserializeBinaryTree {

    public TreeNode solve(ArrayList<Integer> A) {
        TreeNode current,node = null;

        if(A.isEmpty()){
            return  node;
        } else {
            node = new TreeNode(A.get(0));
        }

        Queue<TreeNode>  queue = new LinkedList<>();
        queue.add(node);

        int i =1;
        while (!queue.isEmpty()){
            current= queue.remove();
            if (current!= null){
                TreeNode left = getNode(A.get(i));
                current.left = left;
                queue.add(left);
                i++;

                TreeNode right = getNode(A.get(i));
                current.right = right;
                queue.add(right);
                i++;
            }
        }

        return node;

    }

    private TreeNode getNode(int val) {
        TreeNode node = null;
        if (val != -1){
            node = new TreeNode(val);
        }
        return  node;
    }

}

//We can do this simply by using a queue data structure.
//
//We know that the root node will always be the first element of level order traversal.
//Create a root node and push the root node into the queue.
//
//Now, run a loop until the queue is empty and keep a variable, let’s say i, for denoting the current index in the Level Order Traversal.
//
//Pop the Node: If the node is not NULL, then the element at index i will be the left child, and the element at i+1 will be the right child.
//Create those children and push the left child and right child of the node, respectively, in the queue.
//
//After building the tree, return the root node.
