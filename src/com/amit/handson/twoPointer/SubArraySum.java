package com.amit.handson.twoPointer;

//Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
//
//If the answer does not exist return an array with a single element "-1".
//
//First sub-array means the sub-array for which starting index in minimum.

import java.util.ArrayList;
import java.util.List;

public class SubArraySum {

    public static  void main(String[] args){
        int[] A = new int[] {1, 2, 3, 4, 5};
        int B = 5;
        System.out.println(getSubArrays(A,B));
    }

    public static int[] getSubArrays(int[] A, int B) {
        List<Integer> result = new ArrayList<Integer>();

        int[] pfSum = new int[A.length];
        pfSum[0] = A[0];
        for(int i=1;i<A.length;i++){
            pfSum[i]= pfSum[i-1]+A[i];
        }
        int start=0;
        int end = 1;

        while(end<A.length){
            if(pfSum[start]==B){
                result.add(start);
                break;
            }

            if(pfSum[end]==B){
                result.add(end);
                break;
            }

            int diff = pfSum[end]-pfSum[start];
            if(diff == B){
                result.add(start);
                result.add(end);
                break;
            } else if(diff < B){
                end++;
            } else {
                start++;
                if(start == end){
                    end++;
                }
            }
        }

        int[] prims = new int[0];
        int size = 0;
        if(result.isEmpty()){
            size = 1;
            prims = new int[size];
            prims[0]= -1;
        } else if (result.size()==1){
            prims = new int[result.get(0)+1];
            for(int i=0;i<= result.get(0);i++){
                prims[i] = A[i];
            }
        }else if (result.size()==2){
            size = result.get(1)-result.get(0);
            int startIndex=result.get(0)+1;
            prims = new int[size];
            for(int i=0;i< size;i++,startIndex++){
                prims[i] = A[startIndex];
            }
        }

        return prims;
    }
}
