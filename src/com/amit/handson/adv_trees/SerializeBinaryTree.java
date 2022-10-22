package com.amit.handson.adv_trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> output = new ArrayList<>();
        if (A==null){
            output.add(-1);
            return output;
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.add(A);

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode x=q.remove();
                if(x != null){
                    output.add(x.val);
                } else {
                    continue;
                }


                if(x.left!=null){
                    q.add(x.left);
                } else{
                    q.add(null);
                }

                if(x.right!=null){
                    q.add(x.right);
                } else{
                    q.add(null);
                }
            }
        }
        return output;
    }
}

//public ArrayList<Integer> solve(TreeNode root) {
//        ArrayList<TreeNode> output = new ArrayList<>();
//        output.add(root);
//        int front = 0;
//        //Move till all data is not filled
//        while(front != output.size()){
//            int n = output.size();
//            for(int i = front ; i < n ; ++i){
//                front++;
//                if(output.get(i) == null) continue;
//                if(output.get(i).left != null){
//                    output.add(output.get(i).left);
//                }
//                else{
//                    output.add(null);
//                }
//                if(output.get(i).right != null){
//                    output.add(output.get(i).right);
//                }
//                else{
//                    output.add(null);
//                }
//            }
//        }
//        return  new ArrayList<>(output.stream().map((a)->a==null ? -1 : a.val).collect(Collectors.toList()));
//
//    }
