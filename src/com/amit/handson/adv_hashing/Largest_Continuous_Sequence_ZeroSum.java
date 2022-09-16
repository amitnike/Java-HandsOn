package com.amit.handson.adv_hashing;

//Given an array A of N integers.
//
//Find the largest continuous sequence in a array which sums to zero.


import java.util.*;

public class Largest_Continuous_Sequence_ZeroSum {

    public static  void main(String[] args){
        int[] A = new int[] {1,2,-2,4,-4};
        System.out.println(getLargestSubSeq(A));
    }

    private static int[] getLargestSubSeq(int[] a) {
        int[] out = new int[0];
        Map<Long, Integer> input = new HashMap<Long, Integer>();
        Long[] pfSum = new Long[a.length];
        pfSum[0] = Long.valueOf(a[0]);

        //create prefix sum
        for (int i = 1; i < a.length; i++) {
            pfSum[i] = pfSum[i - 1] + a[i];
        }


        int endIndex = 0;
        int startIndex = 0;
        int len1 = -1;
        int len2 = 0;
        for(int i=0;i<pfSum.length;i++) {

            if(pfSum[i] == 0){
                endIndex = i;
                startIndex = 0;
                len1 = i;
            }

            if (!input.containsKey(pfSum[i])) {
                input.put(pfSum[i], i);

            } else if (input.containsKey(pfSum[i]) ){
                //compare with old index and get the new length
               len2  = (int) (i -  input.get(pfSum[i]) -1);
                if(len2>len1){
                    startIndex = input.get(pfSum[i])+1;
                    endIndex = startIndex+len2;
                    len1 = len2;
                }
            }

        }

        if (len1 == -1) {
        }
        else {
            out = new int[endIndex-startIndex+1];
            int j=0;
            for (int i=startIndex;i<=endIndex;i++,j++){
                out[j] = a[i];
            }
        }
        return out;

    }
}
