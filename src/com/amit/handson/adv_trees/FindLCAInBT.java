package com.amit.handson.adv_trees;

import java.util.ArrayList;

//in Binary search tree, find LCA
public class FindLCAInBT {

    ArrayList<Integer> BList = new ArrayList<>();
    ArrayList<Integer> CList = new ArrayList<>();
    public int lca(TreeNode A, int B, int C) {
        int op = -1;
        if(A==null){
            return 0;
        }


        boolean stat1 = search(A,B,BList);
        boolean stat2 = search(A,C,CList);

        if(!stat1 || !stat2)
            return -1;

        int i;
        for (i = 0; i < BList.size() && i < CList.size(); i++) {
            if (!BList.get(i).equals(CList.get(i)))
                break;
        }
        return BList.get(i - 1);
    }

    private boolean search(TreeNode A, int val,ArrayList<Integer> lst){

        if(A==null){
            return  false;
        }

        lst.add(A.val);
        if(A.val == val ){
            return true;
        }

        if(A.left!= null && search(A.left,val,lst)) {
            return true;
        }

        if(A.right!=null && search(A.right,val,lst)){
            return true;
        }

        lst.remove(lst.size()-1);
        return  false;
    }
}
