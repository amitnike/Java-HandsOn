package com.amit.handson.twoPointer;

//Given an one-dimensional integer array A of size N and an integer B.
//
//Count all distinct pairs with difference equal to B.
//
//Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.

import java.util.Arrays;

public class PairsWithGivenDifference {

    public static  void main(String[] args){
        int[] A = new int[] {8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3};
        int B = 3;
        System.out.println(getPairsWithDifference(A,B));
    }

    private static int getPairsWithDifference(int[] A, int B) {
        int count = 0;
        //sort the array
        Arrays.sort(A);

        int i = 0;
        int j = 1;

        //above variables to verify if the pair getting repeated or not
        //if repeated increment i and j only
        int p1= -1;
        int p2= -1;

        while (j< A.length){
            if(A[j] - A[i] == B){
                if(p1 != A[j] && p2 != A[i]){
                    count++;
                    p1 = A[j];
                    p2 = A[i];
                }

                i++;
                j++;

           } else if (A[j] - A[i] < B){
                j++;
            } else {
                i++;
                if (i == j){
                    //to avoid collision
                    j++;
                }
            }
        }
        return count;
    }

}
