package com.amit.handson.adv_backTracking;

import com.amit.handson.adv_greedyAlgo.DistributeCandy;

import java.util.ArrayList;
import java.util.Collections;

//Given a set of distinct integers A, return all possible subsets.
//
//NOTE:
//
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//Also, the subsets should be sorted in ascending ( lexicographic ) order.
//The list is not necessarily sorted.
//
//Example Input
//Input 1:
//
//A = [1]
//Input 2:
//
//A = [1, 2, 3]
//
//
//Example Output
//Output 1:
//
//[
//    []
//    [1]
//]
//Output 2:
//
//[
// []
// [1]
// [1, 2]
// [1, 2, 3]
// [1, 3]
// [2]
// [2, 3]
// [3]
//]
public class Subsets {
    public static void main(String[] args){
        ArrayList < Integer > input = new ArrayList < Integer > ();
        input.add(1);
        input.add(2);
        input.add(3);
        Subsets dc = new Subsets();
        System.out.println(dc.subsets(input));
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Collections.sort(A);
        result.add(new ArrayList<Integer>());
        subsequence(A, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public static void subsequence(ArrayList<Integer> arr, int index, ArrayList<Integer> sequence, ArrayList<ArrayList<Integer>> result){
        if(index==arr.size()){
            return;
        }
        ArrayList<Integer> temp = new ArrayList<Integer>(sequence);
        temp.add(arr.get(index));
        result.add(temp);
        subsequence(arr, index+1, temp, result);
        subsequence(arr, index+1, sequence, result);
    }
}
