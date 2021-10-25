package com.coding.practice;

public class Search {

    public static void main(String[] args) {
        System.out.println("Hello");
        int[] test1 = {1, 2, 3, 4, 5, 6, 7};
        int res1 = findByLinearSearch(test1, 6);
        if (res1 != 6)
            System.out.println("Index Expected 5 found: " + res1);
        int[] test2 = {1, 2, 3, 4, 5, 6, 7};
        int res2 = findByLinearSearch(test1, 7);
        if (res2 != 6)
            System.out.println("Index Expected 5 found: " + res2);

        int res3 = findByBinarySearch(test1, 7, 0, test1.length);

    }

    public static int findByBinarySearch(int[] contents, int target, int start, int end) {
        //int start =0; int end = contents.length;
        System.out.println("Start" + start + " End:" + end);
        String s = "hello";
        if (start >= end)
            return -1;
        int mid = start+ (end - start) / 2;
        if (target == contents[mid])
            return mid;
        if (target < contents[mid]) {
            return findByBinarySearch(contents, target, start, mid - 1);
        }
        if (target > contents[mid]) {
            return findByBinarySearch(contents, target, mid + 1, end);
        }
        return -1;
    }

    public static int findByLinearSearch(int[] contents, int target) {
        for (int i = 0; i < contents.length; i++)
            if (contents[i] == target)
                return i;
        return -1;
    }

}
