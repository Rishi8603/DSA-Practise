package Trees.BST;

import Trees.Node;

import java.util.*;
public class BinaryTreePathByArrayList {
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
    public static ArrayList<ArrayList<Integer>> binaryTreePaths(Node root){
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        if (root == null) return list;
        ArrayList<Integer> arr=new ArrayList<>();
        helper(list,root,arr);
        return list;
    }
    public static void helper(ArrayList<ArrayList<Integer>> list,Node root,ArrayList<Integer> arr){
        if (root == null) {
            return; // Base case: if root is null, just return
        }

        // Add current node's value to the string path
        arr.add(root.val);

        // If it is a leaf node, add the path to the list
        if (root.left == null && root.right == null) {
            ArrayList<Integer> nlist=new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                nlist.add(arr.get(i));
            }
            list.add(nlist);
            arr.remove(arr.size()-1);
            return; // Return after adding the path for leaf node
        }

        // Recursively go to the left and right subtrees if they are not null
        if (root.left != null) {
            helper(list, root.left, arr);
        }
        if (root.right != null) {
            helper(list, root.right, arr);
        }

        arr.remove(arr.size()-1);
    }
}