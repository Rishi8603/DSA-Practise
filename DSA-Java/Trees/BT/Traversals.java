package Trees.BT;

import Trees.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Traversals {
    public static void preorder(Node root){
        if(root==null) return;//base case
        System.out.print(root.val+" ");
        preorder(root.left);//left subtree
        preorder(root.right);//right subtree
    }
    public static void inorder(Node root){
        if(root==null) return;//base case

        inorder(root.left);//left subtree
        System.out.print(root.val+" ");
        inorder(root.right);//right subtree
    }
    public static void postorder(Node root){
        if(root==null) return;//base case

        postorder(root.left);//left subtree
        postorder(root.right);//right subtreef
        System.out.print(root.val+" ");
    }
    public static void levelOrder(Node root){
        Queue<Node> q=new LinkedList<>();
        if(root!=null) q.add(root);
        while(q.size()>0){
            Node front=q.remove();
            System.out.print(front.val+" ");
            if(front.left!=null) q.add(front.left);
            if(front.right!=null) q.add(front.right);
        }
    }
    static int n=2;
    public static void nthLevel(Node root,int level){
        if(root==null) return;//base case
        if(level==n) System.out.print(root.val+" ");
        nthLevel(root.left,level+1);//left subtree
        nthLevel(root.right,level+1);//right subtree
    }

    Node root;
    public static void main(String[] args) {
        Node a = new Node(1);//a is the root
        Node b=new Node(2);
        Node c=new Node(2);
        Node d=new Node(4);
        Node e=new Node(6);
        Node f=new Node(6);
        Node g=new Node(4);
        a.left=b;a.right=c;
        b.left=d;b.right=e;
        c.left=f;c.right=g;
        System.out.print("preorder:");
        preorder(a);
        System.out.println();
        System.out.print("inorder:");
        inorder(a);
        System.out.println();
        System.out.print("postorder:");
        postorder(a);
        System.out.println();
        System.out.print("level order:");
        levelOrder(a);
        System.out.println();
        System.out.print("nth level order:");
        nthLevel(a,0);
        //level order traversal using dfs
//        for (int x = 0; x < 4; x++) {
//            n=x;
//            nthLevel(a,0);
//            System.out.println();
//        }
    }
}
