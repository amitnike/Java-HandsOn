package com.amit.handson.adv_trees;

//Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.
//
//Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightView {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans=new ArrayList<>();
        if (A==null){
            return  ans;
        }

        //tweak in level order logic,to read from right to left
        //then  the first node in every list  and add it to answer list
        Queue<TreeNode> q=new LinkedList<>();
        q.add(A);
        while(!q.isEmpty()){
            ArrayList<Integer> tmp=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode x=q.remove();
                tmp.add(x.val);
                if(x.right!=null){
                    q.add(x.right);
                }
                if(x.left!=null){
                    q.add(x.left);
                }
            }
            ans.add(tmp.get(0));
        }
        return ans;
    }
}
