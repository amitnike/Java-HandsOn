package com.amit.handson.adv_trees;

//in Binary search tree, find LCA
public class FindLCA {
    public int lca(TreeNode A, int B, int C) {
        TreeNode temp = A;

        if(B<temp.val && C< temp.val){
            temp = temp.left;
        } else if(B>temp.val && C> temp.val){
            temp = temp.right;
        }
         return temp.val;
    }

}
