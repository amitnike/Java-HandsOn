package com.amit.handson.Intro;

//You are given N positive integers.
//
//For each given integer A, you have to tell whether it is a perfect number or not.
//
//A perfect number is a positive integer which is equal to the sum of its proper positive divisors
//1 <= N <= 10
//
//1 <= A <= 106

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int input = in.nextInt();
            String isPerfect = isPerfect(input);
            System.out.println(isPerfect);
        }
    }

    private static String isPerfect(int input) {
        int sum = 1;
        if (input == 1){
            return  "NO";
        }

        for (int i=2;i< input;i++){
            if(input% i ==0) {
                sum = sum+i ;
            }
        }
        if (sum == input ){
            return "YES";
        } else {
            return "NO";
        }

    }
}
