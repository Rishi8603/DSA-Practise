package Trees.BST;

import Trees.Node;

import java.util.ArrayList;

public class SortedToBST2 {
    public static void main(String[] Args) {

    }
    public static Node balanceBST(Node root) {
       return helper1(root);
    }
    public static Node helper1(Node root){
        ArrayList<Integer> list=new ArrayList<>();
        inorder(root,list);
        int[] nums = list.stream().mapToInt(Integer::intValue).toArray();
        return helper2(nums,0,nums.length-1);
    }
    public static Node helper2(int[] nums, int low, int high){
        if(low>high) return null;
        int mid=low+(high-low)/2;
        Node root=new Node(nums[mid]);
        root.left=helper2(nums,low,mid-1);
        root.right=helper2(nums,mid+1,high);
        return root;
    }
    public static void inorder(Node root,ArrayList<Integer> list){
        if(root==null) return;//base case

        inorder(root.left,list);//left subtree
        list.add(root.val);
        inorder(root.right,list);//right subtree
    }
}