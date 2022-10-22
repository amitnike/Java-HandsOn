package com.amit.handson.adv_trees;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode root = A;

        while(root != null || !stack.isEmpty()){
            while(root != null){
                //add node values to list and push node into stack
                out.add(root.val);
                stack.push(root);
                //get the left
                root = root.left;
            }
            //if root.left is null..pop the top and get its right
            TreeNode temp = stack.pop();
            root = temp.right;
        }
        return out;
    }
}
