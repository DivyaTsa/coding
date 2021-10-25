package com.coding.practice;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {


    static Node currentN;
    static Stack<Node> stack = new Stack<>();

    public static void main(String[] args) {
        BinaryTreeTraversal btt = new BinaryTreeTraversal();
        System.out.println("Hello");
        Node root= Node.getTreeRoot();
        List<Integer> list = traversePreOrder(root);
        System.out.println("PreOrder!");
        list.forEach(System.out::print);
        list = traverseInOrder(root);
        System.out.println("\nIn Order!");
        list.forEach(System.out::print);


        System.out.println("\nPost Order!");
        list = traversePostOrder(root);
        list.forEach(System.out::print);

        System.out.println("\n Iterator Test");
        Node node = btt.nextItem();
        while (node != null) {
            System.out.print(node.data);
            node = btt.nextItem();
        }

    }

    public static List<Integer> traversePreOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.data);
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                stack.push(root.left);

        }

        return list;
    }

    public static void traverseInOrderIter(Node root) {
        currentN = root;
        while (currentN != null || !stack.isEmpty()) {
            while (currentN != null) {
                stack.push(currentN);
                currentN = currentN.left;
            }
            currentN = stack.pop();
            break;
            //list.add(current.data);
            //current = current.right;
        }

        //return list;
    }

    public static List<Integer> traversePostOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> nodes = new Stack<>();
        Stack<Node> result = new Stack<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.pop();
            if (node.left != null)
                nodes.push(node.left);
            if (node.right != null)
                nodes.push(node.right);
            result.push(node);
            //if(node.left==null)
        }
        while (!result.isEmpty()) {
            list.add(result.pop().data);
        }
        return list;
    }

    public Node nextItem() {
        Node result = currentN;
        if (currentN != null) {
            currentN = currentN.right;
            traverseInOrderIter(currentN);
        }
        return result;
    }
	


	public static List<Integer> traverseInOrder(Node root)
	{
		List<Integer> list = new ArrayList<>();
		if(root==null)
			return list;
		Stack<Node> stack = new Stack<>();
		//stack.push(root);
		Node curr = root;
		while(curr!=null || !stack.isEmpty())
		{
			while(curr!=null)
			{
			   stack.push(curr);
			   curr = curr.left;
			}
			curr = stack.pop();
			list.add(curr.data);
			curr=curr.right;
		}
		return list;
	}


}
