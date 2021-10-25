package com.coding.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BreadthFirst {
    public static void main(String[] args) {

        System.out.println("Hello World!");
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        breadthFirst(root);
        breadthFirstNodesPerLevel(root);
        deapthFirst(root);

    }
    public static void deapthFirst(Node root)
    {
        System.out.println("Deapth First");
        if(root==null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            root=stack.pop();
            System.out.print(root.data+" ");
            if(root.right!=null)
                stack.push(root.right);
            if(root.left!=null)
                stack.push(root.left);

        }
    }

    public static void breadthFirst(Node root)
    {
        if(root==null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level=0;
        while(!queue.isEmpty())
        {
            System.out.println("Level-"+(++level));
            for(int i=queue.size();i>0;i--) {
                root=queue.poll();
                System.out.print(root.data+" ");
                if (root.left != null)
                    queue.add(root.left);
                if (root.right != null)
                    queue.add(root.right);
            }
        }

    }



    public static void breadthFirstNodesPerLevel(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        while (!q.isEmpty()) {
            System.out.println("Level :" + level++);
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                System.out.print(node.data + " ");
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            System.out.println("");
        }
    }

   /* public static void breadthFirst(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }*/

}
