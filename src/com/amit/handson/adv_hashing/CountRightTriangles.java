package com.amit.handson.adv_hashing;

//Given two arrays of integers A and B of size N each, where each pair (A[i], B[i])
// for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.
//
//Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k])
// form a right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.
//
//NOTE: The answer may be large so return the answer modulo (109 + 7).

import java.util.HashMap;
import java.util.Map;

public class CountRightTriangles {
    public static  void main(String[] args){
        int[] A = new int[] {1, 1, 2, 3, 3};
        int[] B = new int[] {1, 2, 1, 2, 1};
        System.out.println(countRightTriangle(A,B));
    }

    private static int countRightTriangle(int[] A,int[] B) {
        int ret = 0;
        //elements over x axis
        Map<Integer,Long> mapX = new HashMap<Integer,Long>();
        for(int i=0;i<A.length;i++){
            if(!mapX.containsKey(A[i])){
                mapX.put(A[i], Long.valueOf(1));
            } else {
                Long val = mapX.get(A[i]);
                mapX.put(A[i],val+1);
            }
        }
        //elements over Y axis
        Map<Integer,Long> mapY = new HashMap<Integer,Long>();
        for(int i=0;i<B.length;i++){
            if(!mapY.containsKey(B[i])){
                mapY.put(B[i], Long.valueOf(1));
            } else {
                Long val = mapY.get(B[i]);
                mapY.put(B[i],val+1);
            }
        }

        int mod = 1000000007;
        Long a = Long.valueOf(0);
        Long b = Long.valueOf(0);
        for(int i=0;i<A.length;i++){
            if(mapX.containsKey(A[i])){
                a = mapX.get(A[i])-1;
            }

            if(mapY.containsKey(B[i])){
                b = mapY.get(B[i])-1;
            }

            ret += (int) (a*b) % mod;

        }
        return ret%mod;

    }

}
