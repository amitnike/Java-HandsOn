package com.amit.handson.stack;

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
        int out = 1;
        arr = new char[A.length()];

        for(int i=0;i<A.length();i++){
            char ch = A.charAt(i);

            if (ch == '('){
                this.push(ch);
            } else if (ch == '+' || ch == '*' ||ch == '/' || ch == '-') {
                this.pop();
            }
        }

        if(this.isEmpty()){
            out = 0;
        } else {
            out = 1;
        }
        return  out;
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
