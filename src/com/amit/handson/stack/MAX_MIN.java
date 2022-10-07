package com.amit.handson.stack;

//Given an array of integers A.
//
//value of a array = max(array) - min(array).
//
//Calculate and return the sum of values of all possible subarrays of A modulo 109+7.

import java.util.Stack;

public class MAX_MIN {

    public static void main(String[] args){
        int[] A = new int[]{4,7,3,8};
        MAX_MIN bp = new  MAX_MIN();
        System.out.println(bp.solve(A));
    }

    private int solve(int[] A) {
        int mod = 1000000007;
        long ans = 0;

        int sl[] = getSmallElementsOnLeft(A);
        int sr[] = getSmallElementsOnRight(A);
        int gl[] = getGreaterElementsOnLeft(A);
        int gr[] = getGreaterElementsOnRight(A);

        for(int i=0;i<A.length;i++){

            long left = (i-gl[i]);
            long right = (gr[i] - i);

            ans = (ans + ((long)A[i]*(left*right)%mod)%mod)%mod;

            left = (i-sl[i]);

            right = (sr[i]-i);

            ans = (ans - ((long)A[i]*(left*right)%mod)%mod)%mod;

            ans = (ans+mod)%mod;

            // above logic simplifies the below expression for larger int
//            maxSum = maxSum + (A[i]) * ((i - gl[i])) * ((gr[i] - i));

//            minSum = minSum + (A[i]) * ((i - sl[i])) * ((sr[i] - i));
        }

        return (int) ans;
    }

    private int[] getGreaterElementsOnRight(int[] A) {
        Stack<Integer> stack = new Stack <> ();
        int[] out = new int[A.length];

        for(int i=A.length-1;i>=0;i--){
            while(!stack.isEmpty() && A[stack.peek()] <= A[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                // no small element found
                out[i] = A.length;
            } else {
                //small element found
                out[i] = stack.peek();
            }
            stack.push(i);
        }
        return out;
    }

    private int[] getGreaterElementsOnLeft(int[] A) {
        Stack<Integer> stack = new Stack <> ();
        int[] out = new int[A.length];

        for(int i=0;i<A.length;i++){
            while(!stack.isEmpty() && A[stack.peek()] <= A[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                // no greater element found
                out[i] = -1;
            } else {
                //greater element fou d
                out[i] = stack.peek();
            }
            stack.push(i);
        }
        return out;
    }

    private int[] getSmallElementsOnRight(int[] A) {
        Stack<Integer> stack = new Stack <> ();
        int[] out = new int[A.length];

        for(int i=A.length-1;i>=0;i--){
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                // no small element found
                out[i] = A.length;
            } else {
                //small element found
                out[i] = stack.peek();
            }
            stack.push(i);
        }
        return out;
    }

    private int[] getSmallElementsOnLeft(int[] A) {
        Stack<Integer> stack = new Stack <> ();
        int[] out = new int[A.length];

        for(int i=0;i<A.length;i++){
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                // no small element found
                out[i] = -1;
            } else {
                //small element fou d
                out[i] = stack.peek();
            }
            stack.push(i);
        }
        return out;
    }


}
