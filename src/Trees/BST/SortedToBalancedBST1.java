package Trees.BST;

import Trees.Node;

public class SortedToBalancedBST1 {
    public static void main(String[] args) {
        int[] nums={-1,3,8,21,23,44,50};
        sortedArrayToBST(nums);
    }
    public static Node sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public static Node helper(int[] nums,int low, int high){
        if(low>high) return null;
        int mid=low+(high-low)/2;
        Node root=new Node(nums[mid]);
        root.left=helper(nums,low,mid-1);
        root.right=helper(nums,mid+1,high);
        return root;
    }
}
