package com.amit.handson.adv_hashing;

//Given two arrays of integers A and B of size N each, where each pair (A[i], B[i])
// for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.
//
//Find and return the number of unordered quadruplet (i, j, k, l)
// such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel
// to either x-axis or y-axis.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountRectangles {
    public static  void main(String[] args){
        int[] A = new int[] {1,1,2,2};
        int[] B = new int[] {1,2,1,2};
        System.out.println(countRectangles(A,B));
    }

    private static int countRectangles(int[] A,int[] B) {
        int count = 0;
        Set<String> coordinates = populateSetOfCordinates(A,B);

        for(int i=0;i<A.length;i++){
            int x1 = A[i];
            int y1 = B[i];
            for(int j = i+1;j<A.length;j++){
                int x2 = A[j];
                int y2 = B[j];

                if (x1 == x2 || y1 == y2)
                    continue;

                if (coordinates.contains(getCordinate(x1,y2)) && coordinates.contains(getCordinate(x2,y1)))
                    count++;

            }
            coordinates.remove(getCordinate(x1,y1));
        }

        return count;
    }

    private static Set<String> populateSetOfCordinates(int[] a, int[] b) {
        Set<String> coordinates = new HashSet<String>();
        for(int i=0;i<a.length;i++){
            coordinates.add(getCordinate(a[i],b[i]));
        }
        return  coordinates;
    }

    private static String getCordinate(int i1, int i2) {
        return (i1 + "|"+ i2);
    }

}
