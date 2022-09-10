package com.amit.handson.Intro;

import java.util.Scanner;

public class SquareRoot {

    public static  void main(String[] args){
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        System.out.println(solve(input));
    }

    public static int solve(int A) {
        if(A==1){
            return 1;
        } else {
            return getSquareRoot(1,A,A);
        }

    }

    private static int getSquareRoot(int start,int end,int input) {
        int sqroot = -1;
        long mid = (start + end) / 2;
        while(mid != start){
            if (mid * mid == input){
                sqroot = (int)mid;
                break;
            } else if (mid * mid > input ){
                end = (int)mid;
                sqroot = getSquareRoot(start,end, input);
                break;
            } else if (mid * mid < input ){
                start = (int)mid;
                sqroot = getSquareRoot(start,end, input);
                break;
            }
        }
        return sqroot;
    }
}
