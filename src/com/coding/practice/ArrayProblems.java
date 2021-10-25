package com.coding.practice;

import java.util.HashMap;
import java.util.Map;

public class ArrayProblems {
    public static void main(String[] args) {
        System.out.println("Hello");
		/*int[] nums = {0,1,2,2,3,0,4,2};
		removeElement(nums,2);*/
		/*int[] nums = {17,18,5,4,6,1};
		replaceElements(nums);*/
		/*int[] nums = {3,1,2,4};
		sortArrayByParity(nums);*/
Map map = new HashMap();
        int[] nums = {-1};
        nums = sortedSquares(nums);
        System.out.println("Print Result");
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }

    public static int[] sortArrayByParity(int[] a) {
        int forward = 0, backward = a.length - 1, t = 0;
        while (forward < backward) {
            if (a[forward] % 2 > a[backward] % 2) {
                t = a[forward];
                a[forward] = a[backward];
                a[backward] = t;
            }
            if (a[forward] % 2 == 0)
                forward++;
            if (a[backward] % 2 == 1)
                backward--;
        }

        return a;
    }

    public static int[] sortedSquares(int[] A) {
        int[] negativeSquares = new int[A.length];
        int negIndex = -1, posIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0)
                negativeSquares[++negIndex] = A[i] * A[i];
            else {

                while (negIndex >= 0 && (A[i] * A[i] >= negativeSquares[negIndex])) {
                    A[posIndex++] = negativeSquares[negIndex--];

                }
                A[posIndex++] = A[i] * A[i];
            }

        }
        if (negIndex == A.length - 1)
            return negativeSquares;
        while (negIndex >= 0) {
            A[posIndex++] = negativeSquares[negIndex--];
        }
        return A;
    }

    public static int[] replaceElements(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j] < arr[i]) {
                arr[j--] = arr[i];
            }
            arr[i] = -1;
        }
        return arr;
    }

    public static int removeElement(int[] nums, int val) {
        int writePtr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[writePtr++] = nums[i];
            else
                nums[i] = 0;
        }
        return writePtr;
    }


}
