package com.amit.handson.stack;

import java.util.Stack;

public class Largest_Rectangle_Histogram {

    public static void main(String[] args){
        int[] A = new int[]{47, 69, 67, 97, 86, 34, 98, 16, 65, 95, 66, 69, 18, 1, 99, 56, 35, 9, 48, 72, 49, 47, 1, 72, 87, 52, 13, 23, 95, 55, 21, 92, 36, 88, 48, 39, 84, 16, 15, 65, 7, 58, 2, 21, 54, 2, 71, 92, 96, 100, 28, 31, 24, 10, 94, 5, 81, 80, 43, 35, 67, 33, 39, 81, 69, 12, 66, 87, 86, 11, 49, 94, 38, 44, 72, 44, 18, 97, 23, 11, 30, 72, 51, 61, 56, 41, 30, 71, 12, 44, 81, 43, 43, 27};
        Largest_Rectangle_Histogram bp = new  Largest_Rectangle_Histogram();
        System.out.println(bp.largestRectangleArea(A));
    }

    public int largestRectangleArea(int[] A) {
        int out = Integer.MIN_VALUE;

        if(A.length==1){
            return A[0];
        }

        int lr[] = getIndexOfSmallElementsOnLeft(A);
        int rr[] = getIndexOfSmallElementsOnRight(A);


        for(int i=0;i<A.length;i++){
            out = Math.max(out,A[i]*(rr[i]-lr[i]-1));
        }

        return  out;
    }

    private int[] getIndexOfSmallElementsOnLeft(int[] A) {
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
                //small element found
                out[i] = stack.peek();
            }
            stack.push(i);
        }
        return out;
    }

    private int[] getIndexOfSmallElementsOnRight(int[] A) {
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

}
