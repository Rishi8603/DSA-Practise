package Trees.BT;

import Trees.Node;

public class DisplayNodeOfTree {
    Node root;
    private static void display(Node root){
        if(root==null) return;//base case
        System.out.print(root.val+" ");
        display(root.left);//left subtree
        display(root.right);//right subtree
    }
    public static void main(String[] args) {
        Node a = new Node(1);//a is the root
        Node b=new Node(4);
        Node c=new Node(3);
        Node d=new Node(2);
        Node e=new Node(6);
        Node f=new Node(5);
        System.out.println(a.val);
        a.left=b;a.right=c;
        b.left=d;b.right=e;
        c.right=f;
        d.val=0;
        System.out.println(a.left.left.val);
        Node g=new Node(9);
        Node h=new Node(11);
        e.right=g;
        f.left=h;
        display(a);
        a.left=null;
        System.out.println();
        display(a);
    }
}
