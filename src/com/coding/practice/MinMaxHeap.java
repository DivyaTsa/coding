package com.coding.practice;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinMaxHeap {

    public static void main(String[] args) {
    	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
        minHeap.add(50);
        minHeap.add(30);
        minHeap.add(60);
        Integer[] arr=new Integer[3];
        minHeap.toArray(arr);
        //Arrays.sort(arr);
        System.out.println("Print Array- ");
        for(int i=0;i<3;i++)
            System.out.print(arr[i]+" ");
        System.out.println("\n 50-30-60 - Min Heap ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll()+" ");
        }

        //Max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        maxHeap.add(50);
        maxHeap.add(30);
        maxHeap.add(60);
        System.out.println("\n Max Heap- 50-30-60");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll()+" ");
        }

        Queue<Node> maxHeap1 = new PriorityQueue<Node>((a, b) -> b.data - a.data);
        Node root = Node.getTreeRoot();
        maxHeap1.add(root);
        maxHeap1.add(root.right);
        maxHeap1.add(root.left);
        System.out.println("\nMax Heap");
        while (!maxHeap1.isEmpty()) {
            System.out.print(maxHeap1.poll().data);
        }

    }

    public static int kthLargest(int[] nums,int k)
    {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num:nums)
        {
            queue.add(num);
            if(queue.size()>k)
                queue.poll();
        }
        return queue.poll();
    }

}
