package com.amit.handson.adv_trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        if (A==null){
            return  ans;
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.add(A);
        while(!q.isEmpty()){
            ArrayList<Integer> tmp=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode x=q.remove();
                tmp.add(x.val);
                if(x.left!=null){
                    q.add(x.left);
                }
                if(x.right!=null){
                    q.add(x.right);
                }
            }
            ans.add(tmp);
        }

        return ans;
    }

}
