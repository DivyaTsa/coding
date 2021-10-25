package com.coding.practice;

import java.util.PriorityQueue;

public class DuplicateNumberArray {
    public static void main(String[] args) {
        System.out.println("Hello");
        int[] n = new int[0];
        int[] nums = {3, 3, 3, 4, 4, 5, 6, 6, 1, 1, 2};
        PriorityQueue<Integer> q = new PriorityQueue<>();

        System.out.println(eliminateDuplicate(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            q.add(nums[i]);
        }
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }

    
    public int eliminateDup(int[] nums)
    {
    	int index=1;
    	for(int i=1;i<nums.length;i++)
    	{
    		if(nums[i-1]!=nums[i])
    			nums[index++]=nums[i];
    	}
    	for(int i=index;i<nums.length;i++)
    	{
    		nums[i]=0;
    	}
    	return index;
    }
    
    
    
    
    
    
    
    public static int eliminateDuplicate(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++)
            nums[i] = 0;
        return index;

    }

}
