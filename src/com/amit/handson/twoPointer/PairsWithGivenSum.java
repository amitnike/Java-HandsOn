package com.amit.handson.twoPointer;

//Given a sorted array of distinct integers A and an integer B,
// find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B

import java.util.Scanner;

public class PairsWithGivenSum {

    public static  void main(String[] args){
        int[] A = new int[] {1, 2, 3, 4, 5};
        int B = 5;
        System.out.println(getPairsWithCount(A,B));
    }

    private static int getPairsWithCount(int[] a, int b) {
        int count = 0;

        int i=0;
        int j = a.length-1;

        while(i<j){

            if(a[i]+a[j] == b){
                count++;
                i++;
                j--;
            } else if(a[i]+a[j] > b){
                j--;
            } else {
                i++;
            }
        }
        return  count;
    }
}
