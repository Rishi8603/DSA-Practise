package Trees.BST;

import Trees.Node;

import java.util.*;

public class BinaryTreePathByString {
    public static List<String> binaryTreePaths(Node root){
        ArrayList<String> list=new ArrayList<>();
        if (root == null) return list;
        helper(list,root,"");
        return list;
    }
    public static void helper(ArrayList<String> list,Node root,String s){
        if (root == null) {
            return; // Base case: if root is null, just return
        }

        // Add current node's value to the string path
        s = s + root.val;

        // If it is a leaf node, add the path to the list
        if (root.left == null && root.right == null) {
            list.add(s);
            return; // Return after adding the path for leaf node
        }

        // Recursively go to the left and right subtrees if they are not null
        if (root.left != null) {
            helper(list, root.left, s + "->");
        }
        if (root.right != null) {
            helper(list, root.right, s + "->");
        }
    }
    public static void main(String[] args) {
        Node a = new Node(1);//a is the root
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(6);
        Node g=new Node(7);
        a.left=b;a.right=c;
//        b.left=d;
        b.right=e;
//        e.right=g;
//        c.right=g;
//        c.left=f;
        System.out.println(binaryTreePaths(a));
    }
}
