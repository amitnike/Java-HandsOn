package com.amit.handson.adv_trees;

import java.util.List;

public class SortedArraytoBalBST {
    public TreeNode sortedArrayToBST(final List<Integer> A) {

        return getBalanceBST(A,0,A.size()-1);

    }

    private TreeNode getBalanceBST(List<Integer> A, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = (start+end)/2;
        TreeNode root = new TreeNode(A.get(mid));

        root.left = getBalanceBST(A,start,mid-1);
        root.right = getBalanceBST(A,mid+1,end);

        return  root;
    }

}
