package com.coding.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BinaryTreeRecursion {
/*		1
	2		3
  4  5 	  6   7	
  */

    public static void main(String[] args) {
        Node root = Node.getTreeRoot();
        List<String> pathList = new ArrayList<>();
        inOrderTraverse(root);
        preOrderTraverse(root, "", pathList);
        pathList.forEach(System.out::println);
        System.out.println("Sum of Left Nodes :" + sumOfLeftNodes(root));
        System.out.println("Post order traversal :");
        postOrderTraverse(root);
        System.out.println("In order traverse: ");
        inOrderTraverse(root);
    }

    private static void inOrderTraverse(Node root)
    {
        if(root==null)
            return;
        inOrderTraverse(root.left);
        System.out.print(root.data);
        inOrderTraverse(root.right);
    }

    private static Node deletePostOrderTraverse(Node root, Set<Integer> toDelete,List<Node> rootList)
    {
        if(root == null)
            return null;
        root.left =deletePostOrderTraverse(root.left,toDelete,rootList);
        root.right= deletePostOrderTraverse(root.right,toDelete,rootList);
        System.out.print(root.data+" ");
        if(toDelete.contains(root.data))
        {
            if(root.left!=null)
                rootList.add(root.left);
            if(root.right!=null)
                rootList.add(root.right);
            root=null;
        }
        return root;
    }

    private static void postOrderTraverse(Node root)
    {
        if(root == null)
            return;
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.print(root.data+" ");
    }

    private static void preOrderTraverse(Node node, String path, List<String> pathList) {

        System.out.println(path);
        path += node.data;
        if (node.right == null && node.left == null)
            pathList.add(path);
        if (node.left != null)
            preOrderTraverse(node.left, path + "->", pathList);
        if (node.right != null)
            preOrderTraverse(node.right, path + "->", pathList);

    }

    private static int sumOfLeftNodes(Node node) {
        if (node == null)
            return 0;
        if (node.left != null && isLeafNode(node.left)) {
            System.out.print(node.left.data + " ");
            return node.left.data;
        } else
            return sumOfLeftNodes(node.left) + sumOfLeftNodes(node.right);
    }

    private static boolean isLeafNode(Node node) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null)
            return true;
        else
            return false;
    }

}
