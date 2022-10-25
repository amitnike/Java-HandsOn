package com.amit.handson.adv_trees;

//Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.
//
//The diameter of a tree is the number of edges on the longest path between two nodes in the tree.

//Example Input
//Input 1:
//
//           1
//         /   \
//        2     3
//       / \
//      4   5
//Input 2:
//
//            1
//          /   \
//         2     3
//        / \     \
//       4   5     6
//
//
//Example Output
//Output 1:
//
// 3
//Output 2:
//
// 4
public class DiameterOfBinaryTree {

    public int solve(TreeNode A) {

        if(A== null){
            return 0;
        }

        int lHeight = getHeight(A.left);
        int rHeight = getHeight(A.right);

        int lDiameter = solve(A.left);
        int rDiameter = solve(A.right);

        return Math.max(lHeight + rHeight + 1,
                Math.max(lDiameter, rDiameter));

    }

    private int getHeight(TreeNode node) {
        if(node == null){
            return  0;
        }

        return 1+ Math.max(getHeight(node.left),getHeight(node.right));
    }

}
