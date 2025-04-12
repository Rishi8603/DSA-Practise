package Trees.BT;

import Trees.Node;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructBinaryTreeFromInorderAndPostorder {
    Class node;
    public static void main(String[] args) {
        int[] inorder={2,3,1};
        int[] postorder={3,2,1};
        Node a=buildTree(inorder,postorder);
        levelOrder(a);
    }
    public static Node buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        return helper(inorder,postorder,0,n-1,0,n-1,n);
    }
    public static Node helper(int[] inorder,int[] postorder,int inL,int inH,int postL,int postH,int n){
        if(postL>postH || inL>inH) return null;
        Node root=new Node(postorder[postH]);
        int r=n-1;//ye inorder mein root khojne ke liye
        while(inorder[r]!=postorder[postH]){
            r--;
        }
        int rightsize=inH-r;
        root.left=helper(inorder,postorder,inL,r-1,postL,postH-rightsize-1,n);
        root.right=helper(inorder,postorder,r+1,inH,postH-rightsize,postH-1,n);
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
