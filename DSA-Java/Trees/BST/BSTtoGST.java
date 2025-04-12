package Trees.BST;

import Trees.Node;

public class BSTtoGST {
    public static void main(String[] args) {
        Node a = new Node(3);  // Root
        Node b = new Node(2);
        Node c = new Node(4);
        Node d = new Node(1);
        Node e = new Node(2);
        Node f = new Node(5);
        Node g = new Node(7);
        Node h = new Node(3);
        Node i = new Node(8);

        // Connect nodes to form the binary tree
        a.left = b;
        a.right = c;
        b.left = d;
        bstToGst(a);
    }
    public static int sum=0;
    public static Node bstToGst(Node root) {
        if(root==null) return null;
        helper(root);
        return root;
    }
    public static void helper(Node root){
        if(root.right==null && root.left==null){
            sum=sum+root.val;
            root.val=sum;
            return ;
        }
        if(root.right!=null) helper(root.right);
        sum=sum+root.val;
        root.val=sum;

        if(root.left!=null) helper(root.left);
    }
}
