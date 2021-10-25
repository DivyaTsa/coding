package com.coding.practice;

import java.util.Stack;

public class DepthFirst {

    public static void main(String[] args) {
        System.out.println("Hello");
        String str = "Hello";
        char[] charArray = str.toCharArray();
        System.out.println(str.contains("el"));
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        depthFirst(root);
    }

    public static void depthFirst(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node element = stack.pop();
            System.out.println(element.data);
            if (element.right != null) {
                stack.push(element.right);
            }
            if (element.left != null) {
                stack.push(element.left);
            }

        }

    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

}
