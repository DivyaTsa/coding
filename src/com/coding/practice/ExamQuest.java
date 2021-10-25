package com.coding.practice;

import java.util.Stack;

public class ExamQuest {

    /*	Given a binary tree, write an iterator that returns the next element, as would appear in post order traversal

        For example, given -

              1
            /  \
           2     3
          / \   / \
        4   5   6  7

        Every time the next iterator is called, we return elements in the order of -
        1st time: 2
        2nd time: 3
        3rd time: 1

        Assume that the node is of the form -
        class Node {
          int value;
          Node left;
          Node right;


        }
        function next() : int {
            Node current = stack.poll();
             return current.value;
          }
    */
    Stack<Node> stack = new Stack<>();

    public ExamQuest(Node root) {

        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);
            stack.push(root);

        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        //ExamQuest t = new ExamQuest(root);
        //t.printStack();
        System.out.println("Post Order");
        printPostOrder(root);
        System.out.println("Pre Order");
        printPreOrder(root);
        System.out.println("In Order");
        printInOrder(root);
    }

    public static void printPostOrder(Node node) {
        if (node == null)
            return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.value);
    }

    public static void printPreOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.value);
        printPreOrder(node.left);
        printPreOrder(node.right);

    }

    public static void printInOrder(Node node) {
        if (node == null)
            return;
        printInOrder(node.left);
        System.out.println(node.value);
        printInOrder(node.right);
    }

    public void printStack() {
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.value);
        }

    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

    }

}
