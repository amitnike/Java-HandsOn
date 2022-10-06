package com.amit.handson.stack;


import java.util.Stack;

//Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
//
//More formally,
//
//G[i] for an element A[i] = an element A[j] such that
//
//j is maximum possible AND
//
//j < i AND
//
//A[j] < A[i]
//
//Elements for which no smaller element exist, consider the next smaller element as -1.
public class Nearest_Smaller_Element {

    public static void main(String[] args){
        int[] A = new int[]{4,5,2,10,8};
        Nearest_Smaller_Element bp = new  Nearest_Smaller_Element();
        System.out.println(bp.prevSmaller(A));
    }


    public int[] prevSmaller(int[] A) {
        Stack<Integer> stack = new Stack <> ();
        int[] out = new int[A.length];

        for(int i=0;i<A.length;i++){
            while(!stack.isEmpty() && stack.peek() >= A[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                // no small element found
                out[i] = -1;
            } else {
                //small element fou d
                out[i] = stack.peek();
            }
            stack.push(A[i]);
        }
        return out;
    }
}
