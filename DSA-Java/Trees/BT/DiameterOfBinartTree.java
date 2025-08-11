package Trees.BT;

import Trees.Node;

public class DiameterOfBinartTree {
    Node root;
    public static int Levels(Node root){
        if(root==null) return 0;
        int a=Levels(root.left);
        int b=Levels(root.right);
        return 1+Math.max(a,b);
    }
    public static int diameterOfBinaryTree(Node root){
        if(root==null) return 0;
        int L1=Levels(root.left);
        int L2=Levels(root.right);
        int dia1=L1+L2;
        int dia2=diameterOfBinaryTree(root.left);
        int dia3=diameterOfBinaryTree(root.right);
        int maxDia =Math.max(dia1,Math.max(dia2,dia3));
        return maxDia;
    }
    public static void main(String[] args) {
        Node a = new Node(1);//a is the root
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(6);
        Node g=new Node(7);
        Node h=new Node(8);
        Node i=new Node(9);
        Node j=new Node(10);
        Node k=new Node(11);
        Node l=new Node(12);
        Node m=new Node(13);
        Node n=new Node(14);
        Node o=new Node(15);
        a.left=b;a.right=c;
        b.left=d;b.right=e;
        c.right=g;c.left=f;
        d.left=h;d.right=i;
        e.left=j;e.right=k;
        f.left=l;f.right=m;
        g.left=n;g.right=o;
        System.out.println(diameterOfBinaryTree(a));
    }
}
