package com.amit.handson.twoPointer;

//Given a sorted array of integers (not necessarily distinct) A and an integer B,
// find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
//
//Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).

public class PairsWithGivenSum_II {

    public static  void main(String[] args){
        int[] A = new int[] {1, 1,1};
        int B = 2;
        System.out.println(getPairsWithCount(A,B));
    }

    private static int getPairsWithCount(int[] A, int B) {
        long count = 0;
        int mod = 1000000007;

        int i = 0;
        int j = A.length-1;

        while(i < j){
            int sum = A[i] + A[j] ;
            if(sum == B){
                if(A[i] == A[j]){
                    long freq = j-i+1;
                    count +=  ((freq*(freq-1))/2)%mod;
                    break;
                } else {
                    long c1 = 0,c2 = 0;
                    int x = A[i];
                    int y = A[j];

                    while(A[i] == x && i<A.length){
                        i++;
                        c1++;
                    }

                    while(A[j] == y && j>=0){
                        j--;
                        c2++;
                    }
                    count += (c1*c2)%mod;
                }
            } else if (sum < B){
                i++;
            } else {
                j--;
            }
        }

        return  (int)count%mod;
    }
}
