package com.amit.handson.Intro;

//For a given number A, print its multiplication table having the first 10 multiples.

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        printTable(input);

    }

    private static void printTable(int input) {
        for (int i=1;i<=10;i++){
            System.out.println(input + " * "+ i + " = "+input*i);
        }
    }
}
