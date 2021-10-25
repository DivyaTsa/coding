package com.coding.practice;


import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    public static void main(String[] args) {
        System.out.println("Hello..");
        BinarySearchTree bst = new BinarySearchTree();
        Node root = new Node(1);
        root.left = new Node(2);
        //root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        Node res = deletNode(root, 4);
        if (res != null)
            System.out.println("Res:" + res.data);

    }

    public static int rangeSum(Node root,int low,int high)
    {
        if(root==null)
            return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int avgSum=0;
        while(!queue.isEmpty()) {
            Node node=queue.poll();
            if (low <= node.data && node.data >= high)
                avgSum = (avgSum+root.data)/2;
            if(node.left!=null && node.data<low)
                queue.add(node.left);
            if(node.right!=null && node.data>high)
                queue.add(node.right);
        }
        return avgSum;
    }

    public static Node deletNode(Node root, int key) {
        Node prev = root;
        Node curr = root;
        while (curr != null && curr.data != key) {
            prev = curr;
            if (key < curr.data)
                curr = curr.left;
            else
                curr = curr.right;
        }
        if (curr == null)
            return root;
        if (prev == null)
            return null;
        if (curr.left == null || curr.right == null) {
            Node next = curr.left == null ? curr.right : curr.left;
            if (next == null && prev.left == curr)
                prev.left = null;
            else if (next == null && prev.right == curr)
                prev.right = null;

            else if (next.data > prev.data)
                prev.left = next;
            else
                prev.right = next;
        } else {
            Node leftmost = curr.right;
            Node prevLeftmost = curr;
            while (leftmost.left != null) {
                prevLeftmost = leftmost;
                leftmost = leftmost.left;
            }
            curr.data = leftmost.data;
            if (prevLeftmost == curr)
                prevLeftmost.right = null;
            else
                prevLeftmost.left = null;
        }

        return root;
    }

    public static Node searchBST(Node root, int val) {
        while (root != null) {
            if (root.data == val)
                return root;
            if (val < root.data)
                root = root.left;
            else
                root = root.right;
        }
        return null;
    }

}
