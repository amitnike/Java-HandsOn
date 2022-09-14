package com.amit.handson.adv_hashing;

//Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
//
//If the given array contains a sub-array with sum zero return 1, else return 0.

//1 <= |A| <= 100000
//
//-10^9 <= A[i] <= 10^9

public class SubArrayWithZeroSum {
    public static  void main(String[] args){
        int[] A = new int[] {1, 2, 3, 4, 5};
        System.out.println(getSubArraysSumZero(A));
    }

    private static int getSubArraysSumZero(int[] a) {
        int ret = 0;
        int[] pfSum = new int[a.length];
        pfSum[0] = a[0];
        if (a[0] ==0){
            return 1;
        }


        for(int i=1;i<a.length;i++){
            pfSum[i] = pfSum[i-1] + a[i];


        }
        return ret;

    }

}
