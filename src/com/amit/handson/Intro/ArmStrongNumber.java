package com.amit.handson.Intro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//You are given an integer N you need to print all the Armstrong Numbers between 1 to N.
//
//If sum of cubes of each digit of the number is equal to the number itself, then the number is called an Armstrong number.
//
//For example, 153 = ( 1 * 1 * 1 ) + ( 5 * 5 * 5 ) + ( 3 * 3 * 3 ).

public class ArmStrongNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        getArmStrongNumbers(input);

    }

    private static void getArmStrongNumbers(int input) {
        List<Integer> list = new ArrayList<Integer>();
        if (input == 1 ){
            list.add(1);
        } else {
            for (int i=1;i<=input;i++){
                int sum = 0;
                int val = i;
                while (val>0){
                    int remainder = val%10;
                    sum =sum + (remainder*remainder*remainder);
                    val = val/10;
                }
                if (sum == i ){
                    System.out.println(i);
                }
            }
        }
    }
}
