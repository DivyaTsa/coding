package com.coding.practice;

public class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
    /*			1
    	   2		  3
    	4	 5		6	7
    		*/
    public static Node getTreeRoot() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }
    public static String getTraversalResult(String order)
    {
        if(order==null||order=="")
        {
            return "";
        }
        else if("PreOrder".equalsIgnoreCase(order))
            return "1245367";
        else if("InOrder".equalsIgnoreCase(order))
            return "4251637";
        else if("PostOrder".equalsIgnoreCase(order))
            return "4526731";
        else if("LevelOrder".equalsIgnoreCase(order))
            return "1234567";
        return "4251637";
    }

}
