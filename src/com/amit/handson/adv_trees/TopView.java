package com.amit.handson.adv_trees;

//Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.
//
//The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
//
//Return the nodes in any order.

import java.util.ArrayList;

//Input 1:
//
//
//            1
//          /   \
//         2    3
//        / \  / \
//       4   5 6  7
//      /
//     8
//Input 2:
//
//
//            1
//           /  \
//          2    3
//           \
//            4
//             \
//              5
//
//
//Example Output
//Output 1:
//
// [1, 2, 4, 8, 3, 7]
//Output 2:
//[1, 2, 3]
public class TopView {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans=new ArrayList<>();
        if (A==null){
            return  ans;
        }
        ans.add(A.val);
        TreeNode temp= A;

        while(temp.left!=null){
            temp = temp.left;
            ans.add(temp.val);
        }

        temp = A;
        while(temp.right!=null){
            temp = temp.right;
            ans.add(temp.val);
        }
        return ans;
    }
}



