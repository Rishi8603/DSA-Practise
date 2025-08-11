package Trees.BT;

import Trees.Node;

public class InvertBinaryTree {
    Node root;
    public static void preorder(Node root){
        if(root==null) return;//base case
        System.out.print(root.val+" ");
        preorder(root.left);//left subtree
        preorder(root.right);//right subtree
    }
    public static void reverse(Node root){
        Node temp;
        if(root==null) return;
        if(root.left==null&&root.right==null) {
            return;
        }
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        reverse(root.left);
        reverse(root.right);
    }
    public static void main(String[] args) {
        Node a = new Node(4);//a is the root
        Node b=new Node(2);
        Node c=new Node(7);
        Node d=new Node(1);
        Node e=new Node(3);
        Node f=new Node(6);
        Node g=new Node(9);
        a.left=b;a.right=c;
        b.left=d;b.right=e;
        c.left=f;c.right=g;
        preorder(a);
        System.out.println();
        reverse(a);
        preorder(a);
    }

}
