package Trees.BST;
import Trees.Node;

import java.util.*;

public class ConstructBSTfromPreorder {
    public static void main(String[] Args){
        int[] nums={};
        bstFromPreorder(nums);
    }
    public static Node bstFromPreorder(int[] preorder) {
        int n=preorder.length;
        int[] inorder=Arrays.copyOf(preorder,n);
        Arrays.sort(inorder);
        return helper(preorder,inorder,0,n-1,0,n-1);
    }
    public static Node helper(int[] preorder, int[] inorder,int preL,int preH,int inL,int inH){
        if(preL>preH || inL>inH) return null;
        Node root=new Node(preorder[preL]);
        int r=0;//ye inorder mein root khojne ke liye
        while(inorder[r]!=preorder[preL]){
            r++;
        }
        int leftsize=r-inL;
        root.left=helper(preorder,inorder,preL+1,preL+leftsize,inL,r-1);
        root.right=helper(preorder,inorder,preL+leftsize+1,preH,r+1,inH);
        return root;
    }
}