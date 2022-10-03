package com.amit.handson.stack;

import java.util.ArrayList;

//Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
//
//Refer to the examples for more clarity.
public class Balanced_Paranthesis {

    ArrayList<Character> arr = new ArrayList<Character>();
    int top = -1;

    public static void main(String[] args){
        String A = "{([])}";
        Balanced_Paranthesis bp = new  Balanced_Paranthesis();
        System.out.println(bp.solve(A));
    }

    public int solve(String A) {
        for(int i=0; i< A.length(); i++){
            char ch = A.charAt(i);

            if((ch == '(') || (ch == '{') || (ch == '[')){
                push(ch);
            }else{
                switch(ch){
                    case ')':
                        if(top() == '('){
                            pop();
                        }
                        else{
                            return 0;
                        }
                        break;

                    case '}':
                        if(top() == '{'){
                            pop();
                        }else{
                            return 0;
                        }
                        break;
                    case ']':
                        if(top() == '['){
                            pop();
                        }else{
                            return 0;
                        }
                        break;
                    case ' ':
                        continue;
                    default:
                        return 0;
                }
            }
        }
        if(isEmpty()){
            return 1;
        }
        return 0;
    }

    public  void push(char x){
        top += 1;
        arr.add(top,x);
    }

    public  void pop(){
        if(!isEmpty()){
            top -= 1;
        }
    }

    public  boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }

    public  char top(){
        if(!isEmpty()){
            return arr.get(top);
        }
        return '0';
    }

}
