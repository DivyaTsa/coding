package com.coding.practice;

public class NumberOfIslands {
    public static void main(String[] args)
    {
        NumberOfIslands m= new NumberOfIslands();
        int[][] matrix = {{0,1,1,0,0},{0,1,1,0,0}};

        System.out.println("No.Of Islands: "+m.numberOfIslands(matrix));
        int[][] matrix2={{1, 1, 0, 0, 0},
                         {0, 1, 0, 0, 1},
                         {1, 0, 0, 1, 1},
                         {0, 0, 0, 0, 0},
                         {1, 0, 1, 0, 1}};
        //System.out.println("No.Of Islands2: "+m.numberOfIslands(matrix2));
        System.out.println("Max Area :"+m.maxAreaIsland(matrix2));
    }

    public int maxAreaIsland(int[][] matrix)
    {
        int area=0;
        for(int row=0;row<matrix.length;row++)
        {
            for(int col=0;col<matrix[0].length;col++)
            {
                if(matrix[row][col]==1)
                {
                    area = Math.max(area,areaDfs(matrix,row,col));
                }
            }
        }
        return area;
    }

    public int areaDfs(int[][] matrix, int row,int col)
    {
        int area=0;
        if(row<0||row>=matrix.length|| col<0 || col>=matrix[0].length || matrix[row][col]==0)
            return area;
        area++;
        matrix[row][col]=0;
        area+=areaDfs(matrix,row+1,col);
        area+=areaDfs(matrix,row-1,col);
        area+=areaDfs(matrix,row,col+1);
        area+=areaDfs(matrix,row,col-1);

        return area;
    }

    public int numberOfIslands(int[][] matrix)
    {
        int count=0;
        for(int row=0;row<matrix.length;row++)
        {
            for(int col=0;col<matrix[0].length;col++)
            {
                if(matrix[row][col]==1)
                {
                    count+=dfs(matrix,row,col);
                }
            }
        }
        return count;
    }

    public static int dfs(int[][] matrix,int row,int col)
    {
        //Error checking
        if(row<0||col<0|| row>=matrix.length || col>=matrix[0].length || matrix[row][col]==0)
            return 0;
        matrix[row][col]= 0;
        dfs(matrix,row+1,col);
        dfs(matrix,row-1,col);
        dfs(matrix,row,col+1);
        dfs(matrix,row,col-1);
        return 1;
    }
}
