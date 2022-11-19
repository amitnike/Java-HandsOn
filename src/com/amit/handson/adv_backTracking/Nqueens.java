package com.amit.handson.adv_backTracking;

import java.util.ArrayList;
import java.util.List;

//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//
//
//
//Given an integer A, return all distinct solutions to the n-queens puzzle.
//
//Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.
public class Nqueens {
    public static void main(String[] args){
        Nqueens dc = new Nqueens();
        dc.solveNQueens(4);
    }
    public String[][] solveNQueens(int A) {
        int col[] = new int[A];
        int diagonal1[] = new int[2*A+1];
        int diagonal2[] = new int[2*A+1];
        int matrix[][] = new int[A][A];
        int row = 0;

        List<String[]> solutions = new ArrayList<String[]>();

        Nqueens(row,col,diagonal1,diagonal2,matrix, A,solutions);

        if(solutions.size() == 0) {
            return new String[0][0];
        }
        // converting list to an array
        String[][] output = new String[solutions.size()][A];
        for (int i = 0; i < solutions.size(); i++) {
            String[] strArray = solutions.get(i);
            for (int j = 0; j < strArray.length; j++) {
                String val = strArray[j];
                output[i][j] = val;
            }
        }

        printSolution(output);
        return output;
    }

    private void Nqueens(int row, int[] col, int[] diagonal1, int[] diagonal2, int[][] matrix, int A,List<String[]> solutions) {

        if(row == A){
            // we have successfully placed the n queens
            String[] currentSolution = new String[A];
            for (int i = 0; i < A; i++) {
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < A; j++) {
                    if (matrix[i][j] == 1) {
                        temp.append('Q');
                    } else {
                        temp.append('.');
                    }
                }
                currentSolution[i] = temp.toString();
            }
            solutions.add(currentSolution);
            return;
        }

        for(int i=0;i<A;i++){
            //try to place the queen in the column
            if((col[i] == 1)||(diagonal1[A+row-i] == 1)||(diagonal2[row+i] == 1)){
                //check if column is blocked OR
                //check if diagonal is blocked for the cell OR
                //check if anti-diagonal is blocked
                continue;
            }

            //if not place the queen in the cell
            matrix[row][i] = 1;

            //now block as per the selections
            col[i] = 1;
            diagonal1[A+row-i] = 1;
            diagonal2[row+i] = 1;

            Nqueens(row+1,col,diagonal1,diagonal2,matrix,A,solutions);

            //remove it from matrix
            matrix[row][i] = 0;
            //now unblock as per the selections
            col[i] = 0;
            diagonal1[A+row-i] = 0;
            diagonal2[row+i] = 0;

        }

    }

    void printSolution(String output[][])
    {
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++){
                System.out.print(" " + output[i][j]
                        + " ");
            }
            System.out.println();
        }
        System.out.println("********");
    }
}
