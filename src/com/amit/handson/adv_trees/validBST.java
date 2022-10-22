package com.amit.handson.adv_trees;

public class validBST {

    public int isValidBST(TreeNode A) {

        if (isValid(A,Integer.MIN_VALUE,Integer.MAX_VALUE)){
            return 1;
        } else {
            return 0;
        }
    }

    private boolean isValid(TreeNode A, int minValue, int maxValue) {
        if(A==null){
            return true;
        }

        if(A.val>= minValue && A.val<=maxValue){
            return  isValid(A.left,minValue,A.val-1) && isValid(A.right,A.val+1,maxValue);
        }

        return false;
    }

}
