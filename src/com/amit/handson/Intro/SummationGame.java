package com.amit.handson.Intro;

import java.util.Scanner;

//Write a program to find sum all Natural numbers from 1 to N where you have to take N as input from user
//1 <= N <= 1000
public class SummationGame {
    public static  void main(String[] args){
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        System.out.println(input*(input+1)/2);
    }
}
