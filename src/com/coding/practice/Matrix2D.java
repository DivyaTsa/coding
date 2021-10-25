package com.coding.practice;

import java.util.*;

public class Matrix2D {
/*
    {{1, 4, 7, 11, 15},
     {2, 5, 8, 12, 19},
     {3, 6, 9, 16, 22},
     {10, 13, 14, 17, 24},
     {18, 21, 23, 26, 30}};

 */
    List<Integer> nodeList = new ArrayList<Integer>();

    public static void main(String[] args) {
        Matrix2D t = new Matrix2D();
     
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int[] matrix1= {1,2,3};
        System.out.println(t.searchMatrix(matrix, 0, 4, 20));
        System.out.println(t.searchMatrixIter(matrix,18));
        System.out.println(t.searchMatrixIter(matrix,20));

    }

    public boolean searchMatrixIter(int[][] matrix,int target)
    {
        int row =0;
        int col = matrix[0].length-1;
        while(row<matrix.length && col>=0)
        {
            if(target==matrix[row][col])
            {
                System.out.println("Row:"+row+",Col:"+col);
                return true;
            }
            else if(target>matrix[row][col])
            {
                row++;
            }
            else
                col--;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int row, int col, int target) {
        System.out.println("M-" + matrix[row][col] + ",(" + row + "," + col + ")");
        if (matrix[row][col] == target)
            return true;
        if (matrix[row][col] < target && row < matrix.length - 1)
            return searchMatrix(matrix, ++row, col, target);
        if (matrix[row][col] > target && col > 0)
            return searchMatrix(matrix, row, --col, target);
        return false;
    }

    

}
