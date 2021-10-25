package com.test;

public class BinarySearchTest {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int startIndx = 0;
        int size = array.length;
        int x = 1;
        int position = binarySearch(array, startIndx, size - 1, x);
        System.out.println("Position=" + position);

    }

    private static int binarySearch(int[] array, int startIndx, int endIndx, int x) {
        int mid = (startIndx + endIndx + 1) / 2;
        if (array[mid] == x)
            return mid;
        else if (x < array[mid])
            return binarySearch(array, startIndx, mid - 1, x);
        else if (x > array[mid])
            return binarySearch(array, mid + 1, endIndx, x);
        else
            return -1;
    }

}
