package com.amit.handson.Intro;

import java.util.Scanner;

//Given an integer A, you have to tell whether it is a prime number or not.
//
//A prime number is a natural number greater than 1 which is divisible only by 1 and itself.
//1 <= A <= 106
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String isPrime = isPrime(Integer.parseInt(input));
        System.out.println(isPrime);
    }

    private static String isPrime(int input) {
        if (input == 1){
            return  "NO";
        }

        for (int i=2;i<= Math.sqrt(input);i++){
            if(input% i ==0) {
                return "NO";
            }
        }
        return "YES";
    }
}
