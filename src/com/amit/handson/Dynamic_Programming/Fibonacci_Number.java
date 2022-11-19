package com.amit.handson.Dynamic_Programming;

import java.util.Scanner;

//Given a positive integer A, write a program to find the Ath Fibonacci number.
//
//In a Fibonacci series, each term is the sum of the previous two terms and the first two terms of the series are 0 and 1.
// i.e. f(0) = 0 and f(1) = 1. Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.
//
//NOTE: 0th term is 0. 1th term is 1 and so on.
public class  Fibonacci_Number {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        System.out.println(getFibonacci(input));

    }

    private static int getFibonacci(int input) {
        int ans = 0;
        if (input == 0)
            return 0;

        if (input == 1)
            return 1;

        int a1 =0;
        int a2 = 1;

        for (int i=2;i<=input;i++){
            ans = a1+a2;
            a1 = a2;
            a2 = ans;
        }

        return  ans;
    }


}
