package com.amit.handson.adv_hashing;

//Given an unsorted integer array A of size N.
//
//Find the length of the longest set of consecutive elements from array A.


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Longest_Consecutive_Sequence {

    public static  void main(String[] args){
        int[] A = new int[] {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(A));
    }

    private static int longestConsecutive(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++)
            set.add(A[i]);

        int start=0;
        int len = 0;
        for (int i = 0; i < A.length; i++) {
            if(!set.contains(A[i]-1)){
                start = A[i];
                len = 1;
            } while(set.contains(start+1)){
                len++;
                start++;
            }
            ans = Math.max(ans,len);
        }

        return  ans;
    }
}
