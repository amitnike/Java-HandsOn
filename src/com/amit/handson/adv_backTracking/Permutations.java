package com.amit.handson.adv_backTracking;

//Given an integer array A of size N denoting collection of numbers , return all possible permutations.
//
//NOTE:
//
//No two entries in the permutation sequence should be the same.
//For the purpose of this problem, assume that all the numbers in the collection are unique.
//Return the answer in any order

import java.util.ArrayList;


public class Permutations {

    public static void main(String[] args){
        ArrayList< Integer > input = new ArrayList < Integer > ();
        input.add(1);
        input.add(2);
        input.add(3);
        Permutations dc = new Permutations();
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        dc.permute(input);
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        permute(0,A.size(),A,output);
        return  output;
    }

    private void permute(int i, int size, ArrayList<Integer> a, ArrayList<ArrayList<Integer>> output) {
        if(i == size){
            output.add(new ArrayList<>(a));
        }

        for(int j=i;j<size;j++){
            swap(a,i,j);
            permute(i+1,size,a,output);
            swap(a,i,j);
        }
    }

    private void swap(ArrayList<Integer> a, int i, int j) {
        if(i>=a.size() || j>= a.size()){
            return;
        }
        int temp = a.get(i);
        a.set(i,a.get(j));
        a.set(j,temp);
    }

}
