package com.amit.handson.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumZero {

    public static  void main(String[] args){
        int[] A = new int[] {-1,0,1,2,-1,4};
        System.out.println(threeSum(A));
    }

    public static int[][] threeSum(int[] A) {
        int[][] output = new int[0][3];
        Arrays.sort(A);
        int B = 0;

        List<List<Integer>> item = new ArrayList<List<Integer>>();

        int p0= Integer.MAX_VALUE;


        for(int i=0;i<A.length-1;i++){
            if(p0 != A[i]){
                int p1= Integer.MAX_VALUE;
                int p2= Integer.MAX_VALUE;

                p0 = A[i];
                int requiredSum = B - A[i];

                int startIndex = i+1;
                int endIndex = A.length-1;

                while (startIndex < endIndex) {

                    int sum = A[startIndex] + A[endIndex];
                    if(sum == requiredSum){

                        if( p1 != A[endIndex] && p2 != A[startIndex]) {
                            List<Integer> items = new ArrayList<Integer>();
                            items.add(A[i]);
                            items.add(A[startIndex]);
                            items.add(A[endIndex]);
                            item.add(items);


                            p1 = A[endIndex];
                            p2 = A[startIndex];
                        }
                        startIndex++;
                        endIndex--;
                    } else if(sum < requiredSum){
                        startIndex++;
                    } else {
                        endIndex--;
                    }
                }
            }
        }
        int rows = item.size();
        output = new int[rows][3];
        for(int i=0;i<rows;i++){
            List<Integer> items = item.get(i);
            output[i] = toIntArray(items);
        }
        return output;
    }

    private static int[] toIntArray(List<Integer> items) {
        int[] ret = new int[items.size()];
        for(int i = 0; i < ret.length; i++)
            ret[i] = items.get(i);
        return ret;
    }
}
