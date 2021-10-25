package com.coding.practice;

public class BinarySearches {
    public static void main(String[] args)
    {
        BinarySearches bs= new BinarySearches();
        System.out.println("Binary Search Problems");
        int[] nums= {4, 5, 6, 7, 2, 3};
        int[] nums1= {2,4, 10, 10, 10,10, 10, 10, 18, 20};
        System.out.println("First Occurance:"+2+"-"+bs.findFirstOccurance(10,nums1));
        int[] nums2= {15,18,20,22,23,24,4,5,6,8,12};
        System.out.println("Rotation count:"+6+"-"+bs.findRotationCount(nums2));
        int[] nums3= {4,5,6,8,12};
        System.out.println("CircularSorted Array Search:"+2+"-"+bs.findInCircularlySortedArray(20,nums2));
    }
    public int findInCircularlySortedArray(int target,int[] nums)
    {
        int low=0,high=nums.length-1;
        int mid=0;
        while(low<=mid)
        {
            mid = low+(high-low)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>=nums[low])
            {
                if(target<nums[mid] && target >= nums[low])
                    high = mid-1;
                else
                    low=mid+1;
            }
            else
            {
                if(target<=nums[high] && target >nums[mid])
                    low=mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }
    public int findRotationCount(int[] nums)
    { //Non duplicate elements
        int low=0,high=nums.length-1;
        int mid=0;
        while(low<=high)
        {
            if(nums[low]<=nums[high])
                return low;
            mid=low+(high-low)/2;
            if(nums[mid]>=nums[low])
                low=mid+1;
            else if(nums[mid]<=nums[high])
                high = mid-1;
        }
        return -1;
    }
    public int findFirstOccurance(int target,int[] nums)
    {
        int result=-1;
        int l=0; int h=nums.length-1;
        int mid=l+(h-l)/2;
        while(l<=h)
        {
            mid=l+(h-l)/2;
            if(target==nums[mid])
            {
                result = mid;
                h=mid-1; //First occurance
                //l=mid+1;  //Last occurance
            }
            else if(target<nums[mid])
                h = mid-1;
            else if(target>nums[mid])
                l= mid+1;
        }
        return result;
    }
    public int findMinFromRotatedSortedArray(int[] nums)
    {
        int start = 0;
        int end = nums.length-1;
        while(start<=end)
        {
            int mid= start+(end-start)/2;
            if(nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1])
                return mid;
           // if(nums[mid]<nums[mid-1] && nums[mid]>nums[mid+1])
        }
        return start;
    }
}
