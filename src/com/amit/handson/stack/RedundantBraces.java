package com.amit.handson.stack;

import java.util.Stack;

//Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
//
//Check whether A has redundant braces or not.
//
//NOTE: A will be always a valid expression and will not contain any white spaces.
public class RedundantBraces {

    char[] arr = new char[0];
    int top = -1;

    public static void main(String[] args){
        String A = "(a)";
        RedundantBraces bp = new  RedundantBraces();
        System.out.println(bp.solve(A));
    }

    private int solve(String A) {
            Stack< Character > stack = new Stack < > ();

            for (int i = 0; i < A.length(); i++) {
                char ch = A.charAt(i);

                if (ch >= 'a' && ch <= 'z') {
                    continue;
                } else if (ch == '(') {
                    stack.push(ch);
                } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                        return 1;
                    }
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        stack.pop();
                    }
                    stack.pop(); //it will pop out the ')'
                }
            }
            return 0;
    }
}