package com.coding.practice;

public class SortProblems {
    public static void main(String[] args)
    {
        System.out.println("Hello");
        SortProblems s = new SortProblems();
        System.out.println(s.quickSelect(new int[]{2,4,5,8,3,1,9},2));

    }

    public int quickSelect(int[] nums,int n)
    {
        //Error validation
       for(int j=0;j<n;j++)
       for(int i=nums.length-1;i>0;i--)
       {
           if(nums[i-1]>nums[i])
           {
               int temp = nums[i];
               nums[i] = nums[i-1];
               nums[i-1]=temp;
           }
       }
       return nums[n-1];
    }
}
