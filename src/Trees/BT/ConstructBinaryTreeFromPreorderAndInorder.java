package Trees.BT;

import Trees.Node;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructBinaryTreeFromPreorderAndInorder {
    Class node;
    public static void main(String[] args) {
        int[] preorder={3,9,20,15,7};
        int[] inorder={9,3,15,20,7};
        Node a=buildTree(preorder,inorder);
        levelOrder(a);
    }
    public static Node buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
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








    private static void levelOrder(Node root){
        Queue<Node> q=new LinkedList<>();
        if(root!=null) q.add(root);
        while(q.size()>0){
            Node front=q.remove();
            System.out.print(front.val+" ");
            if(front.left!=null) q.add(front.left);
            if(front.right!=null) q.add(front.right);
        }
    }
}
