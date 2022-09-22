package com.amit.handson.adv_arrays;

//Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
//
//The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
//
//Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
//
//Find and return the required subarray.

public class Max_Non_Negative_SubArray {

    public static  void main(String[] args){
        int[] A = new int[] {1967513926, 1540383426, -1303455736, -521595368};
        System.out.println(getSubArray(A));
    }

    private static int[] getSubArray(int[] A) {

        long maxSum = Integer.MIN_VALUE;
        int leftIndex = 0;
        int rightIndex = 0;


        long sum = 0;
        for(int i=0;i<A.length;i++){

            if(A[i] < 0){
                sum =0;
            } else {
                sum += A[i];
                if(sum >  maxSum){
                    maxSum =  sum;
                    rightIndex = i;
                }
                if(sum <0) {
                    sum = 0;
                    leftIndex = i +1;
                }
            }
        }

        int[] op = new int[0];
        if(sum == A.length)
            return  op;
        else {
            op = new int[rightIndex - leftIndex + 1];
            int start = 0;
            for (int i = leftIndex; i <= rightIndex; i++, start++) {
                op[start] = A[i];
            }
        }

        return  op;
    }


}
