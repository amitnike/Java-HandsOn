package com.amit.handson.adv_hashing;

//Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
//
//If the given array contains a sub-array with sum zero return 1, else return 0.

//1 <= |A| <= 100000
//
//-10^9 <= A[i] <= 10^9

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithZeroSum {
    public static  void main(String[] args){
        int[] A = new int[] {2,2,1,-3,4,3,1,-8,6,-2,-1};
        System.out.println(checkIfSubArraysSumZero(A));
    }

    private static int checkIfSubArraysSumZero(int[] a) {
        int ret = 0;
        Map<Long,Integer> input = new HashMap<Long,Integer>();
        Long[] pfSum = new Long[a.length];
        pfSum[0] = Long.valueOf(a[0]);

        for(int i=1;i<a.length;i++){
            pfSum[i] = pfSum[i-1] + a[i];
            if(pfSum[i]==0 || a[i]==0)
                return 1;
        }


        //to find if the pfsum has equal elements

        for(int i=0;i<pfSum.length;i++) {
            if (!input.containsKey(pfSum[i])) {
                input.put(pfSum[i], i);
            } else if (input.containsKey(pfSum[i]))
                return 1;
        }
        return ret;

    }

}
