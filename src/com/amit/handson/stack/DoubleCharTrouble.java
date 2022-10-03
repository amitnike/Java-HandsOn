package com.amit.handson.stack;

import java.util.ArrayList;

//You are given a string A.
//
//An operation on the string is defined as follows:
//
//Remove the first occurrence of the same consecutive characters. eg for a string "abbcd", the first occurrence of same consecutive characters is "bb".
//
//Therefore the string after this operation will be "acd".
//
//Keep performing this operation on the string until there are no more occurrences of the same consecutive characters and return the final string.
public class DoubleCharTrouble {

    char[] arr = new char[0];
    int top = -1;

    public static void main(String[] args){
        String A = "abccbc";
        DoubleCharTrouble bp = new  DoubleCharTrouble();
        System.out.println(bp.solve(A));
    }

    public String solve(String A) {
        arr = new char[A.length()];

        for(int i=0;i<A.length();i++){
            char ch = A.charAt(i);

            if(isEmpty()){
                this.push(ch);
            } else {
                char top = this.top();
                if(top == ch){
                    this.pop();
                } else {
                    this.push(ch);
                }
            }
        }
        return String.valueOf(arr).substring(0,top+1).trim();
    }

    public  void push(char x){
        top ++;
        arr[top] = x;
    }

    public  void pop(){
        if(!isEmpty()){
            top--;
        }
    }

    public  boolean isEmpty(){
        return top == -1;
    }

    public  char top(){
        if(!isEmpty()){
            return arr[top];
        }
        return '0';
    }


}
