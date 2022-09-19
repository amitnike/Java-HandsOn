package com.amit.handson.binarySearch;

//Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
//If not, return the index where it would be if it were inserted in order.
//
//NOTE: You may assume no duplicates in the array. Users are expected to solve this in O(log(N)) time.
public class SortedInsertPosition {

    public static  void main(String[] args){
        int[] A = new int[] {1,3,5,6};
        int B = 5;
        System.out.println(searchInsert(A,B));
    }

    public static int searchInsert(int[] A, int B) {
        int N = A.length;
        if (N == 0)
            return 1;
        int l = 0;
        int r = N - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (A[mid] == B) {
                return mid;
            } else if (A[mid] < B) {
                //reject left part
                l = mid + 1;
            } else {
                //reject right part
                r = mid - 1;
            }
        }
        if (A[mid] > B) {
            return mid;
        } else {
            return mid+1;
        }
    }
}
