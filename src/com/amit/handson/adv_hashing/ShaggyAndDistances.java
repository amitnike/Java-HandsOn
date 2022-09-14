package com.amit.handson.adv_hashing;

//Shaggy has an array A consisting of N elements.
// We call a pair of distinct indices in that array a special if elements at those indices in the array are equal.
//
//Shaggy wants you to find a special pair such that the distance between that pair is minimum.
// Distance between two indices is defined as |i-j|. If there is no special pair in the array, then return -1.
//A[i] = A[j]  and j-i is minimum...j>i
//Closest two duplicate elements


import java.util.HashMap;
import java.util.Map;

public class ShaggyAndDistances {

    public static  void main(String[] args){
        int[] A = new int[] {7, 1, 3, 4, 1, 7};
        System.out.println(getPairCount(A));
    }

    private static int getPairCount(int[] a) {
        Map<Integer,Integer> input = new HashMap<Integer,Integer>();
        int val = Integer.MAX_VALUE;

        for(int i=0;i<a.length;i++){
            if (input.containsKey(a[i])){
                val = Math.min(val,i-input.get(a[i]));
                input.put(a[i],i);
            } else {
                input.put(a[i],i);
            }
        }
        if (val == Integer.MAX_VALUE){
            return -1;
        } else {
            return val;
        }
    }
}
