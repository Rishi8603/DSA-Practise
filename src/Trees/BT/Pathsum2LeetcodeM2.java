package Trees.BT;

import Trees.Node;

import java.util.ArrayList;
import java.util.List;

public class Pathsum2LeetcodeM2 {
    public static Class Node;
    public static void main(String[] args) {
        Trees.Node a = new Node(5); // Root
        Node b = new Node(4);
        Node c = new Node(8);
        Node d = new Node(11);
        Node e = new Node(13);
        Node f = new Node(4);
        Node g = new Node(7);
        Node h = new Node(2);
        Node i = new Node(5);
        Node j = new Node(1);

        // Connect nodes to form the binary tree
        a.left = b;
        a.right = c;

        b.left = d;
        c.left = e;
        c.right = f;

        d.left = g;
        d.right = h;

        f.left = i;
        f.right = j;
        System.out.println(hasPathSum2(a,22));
    }
    public static List<List<Integer>> hasPathSum2(Node root, int targetSum){
        List<List<Integer>> list=new ArrayList<>();
        if (root == null) return list;
        ArrayList<Integer> arr=new ArrayList<>();
        helper(list,root,targetSum,arr);
        return list;
    }
    public static void helper(List<List<Integer>> list, Node root, int target,ArrayList<Integer> arr){
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if(root.val==target){
                arr.add(root.val);
                list.add(arr);
            }
            return;
        }
        arr.add(root.val);
        ArrayList<Integer> arr1=copy(arr);
        ArrayList<Integer> arr2=copy(arr);
        helper(list, root.left, target-root.val,arr1);
        helper(list, root.right, target-root.val,arr2);
    }
    public  static  ArrayList<Integer> copy( ArrayList<Integer> arr){
        ArrayList<Integer> list=new ArrayList<>();
        for(int ele:arr){
            list.add(ele);
        }
        return list;
    }
}
