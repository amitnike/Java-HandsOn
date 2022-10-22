package com.amit.handson.adv_trees;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> out = new ArrayList<Integer>();

        if(A == null)
            return out;

        TreeNode node=null;
        Stack<TreeNode> stk = new Stack<>();
        while(A != null || !stk.empty()){
            if(A != null){
                stk.push(A);
                A = A.left;
            } else{
                A = stk.peek();
                if(A.right == null || A.right == node){
                    out.add(A.val);
                    stk.pop();
                    node = A;
                    A = null;
                } else{
                    A = A.right;
                }
            }
        }
        return out;
    }
}
