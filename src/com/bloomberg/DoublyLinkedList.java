package com.bloomberg;

import java.util.Stack;

public class DoublyLinkedList {
    public static void main(String[] args)
    {
        System.out.println("Doubly Linked list problems");
        DoublyLinkedList d = new DoublyLinkedList();
    }

    /*
    Leetcode : 430 , Company: Bloomberg
    You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
    Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
     */
    public Node flattenMultiLevelDoublyLinkedList(Node root)
    {
       if(root==null)
           return null;
        Stack<Node> stack = new Stack<>();
        Node dummyHead = new Node();

        stack.push(root);
        Node current;
        Node prev = dummyHead;
        while(!stack.isEmpty())
        {
            current = stack.pop();
            prev.next = current;
            current.prev= prev;
            if(current.next!=null)
                stack.push(current.next);
            if(current.child!=null)
            {
                stack.push(current.child);
                current.child=null;
            }
            prev=current;
        }
        root.prev=null;
       return root;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}
