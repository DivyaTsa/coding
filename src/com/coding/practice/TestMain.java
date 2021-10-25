package com.coding.practice;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class TestMain {

	public static void main(String[] args) {
		System.out.println("Hello!");
		TestMain t = new TestMain();
		Node root = Node.getTreeRoot();

		System.out.println("\nPre order traversal:\n"+Node.getTraversalResult("PreOrder"));
		t.preOrderTraverse(root);
		/*System.out.println("\nIn order traversal:\n"+Node.getTraversalResult("InOrder"));
		t.inOrderTraverse(root);
		System.out.println("\nLevel order traversal:\n"+Node.getTraversalResult("LevelOrder"));
		t.levelOrderTraverse(root);
		System.out.println("\nPost order traversal:\n"+Node.getTraversalResult("PostOrder"));
		t.postOrderTraverse(root);
		System.out.println("Post Recursion:");
		t.postOrder(root);*/

		/*System.out.println("Dynamic Program:");
		Map<Integer,Boolean> canSumMap = new HashMap<>();
		System.out.println(t.canSum(100,new int[]{1,2,3,4,5},canSumMap));
		System.out.println(t.canSumTabulation(100,new int[]{1,2,3,4,5}));*/
        System.out.println("Most Frequent");
        System.out.println(t.mostFrequent(new int[]{2,3,4,3}));

	}

	public void preOrderTraverse(Node root)
	{
		if(root==null)
			return;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			root = stack.pop();
			System.out.print(root.data+" ");
			if(root.right!=null)
				stack.push(root.right);
			if(root.left!=null)
				stack.push(root.left);
		}
	}

	public int mostFrequent(int[] nums)
	{
		if(nums.length<0)
			return 0;
		int mostFrequent = Integer.MIN_VALUE;
		int frequency = Integer.MIN_VALUE;
		Map<Integer,Integer> frqMap = new HashMap<>();
		for(int num:nums)
		{
		   frqMap.put(num,frqMap.getOrDefault(num,0)+1);
		   if(frqMap.get(num)>frequency)
		   {
		   	  mostFrequent = num;
		   	  frequency = frqMap.get(num);
		   }
		}
		return mostFrequent;
	}

	public boolean canSumTabulation(int target,int[] nums)
	{
		boolean[] result = new boolean[target+1];
		result[0]=true;
		for(int i=0;i<target;i++) {
			for (int num : nums) {
				if(i+num<=target && result[i])
					result[i+num]=true;
			}
		}
		return result[target];
	}

	public boolean canSum(int target, int[] nums, Map<Integer, Boolean> canSumMap)
	{
		if(canSumMap.containsKey(target))
			return canSumMap.get(target);
		if(target==0)
		{
			canSumMap.put(target,true);
			return true;
		}
		for(int num:nums)
		{
			int remainderTarget = target-num;
			if(remainderTarget>=0)
				if(canSum(remainderTarget,nums,canSumMap))
				{
					canSumMap.put(target,true);
					return true;
				}
		}
		canSumMap.put(target,false);
		return false;
	}



	public  void reverseLinkedList(Node head)
	{
		Node current=head;
		Node prev = null;
		Node next = null;
		while(current!=null)
		{
			next = current.right;
			current.right=prev;
			prev=current;
			current=next;
		}
	}



}
