package Trees.BT;

import Trees.Node;

public class ProductSumMaxSizeLevel {
    Node root;
    private static int Sum(Node root){
        if(root==null) return 0;
        int sum=root.val;
        return sum+ Sum(root.left)+ Sum(root.right);
    }
    private static int Product(Node root){
        if(root==null) return  1;
        return root.val* Product(root.left)* Product(root.right);
    }
    private static int Maximum(Node root){
        if(root==null) return Integer.MIN_VALUE;
        int a=Math.max(Maximum(root.left), Maximum(root.right));
        return Math.max(root.val,a);
    }
    private static int Size(Node root){
        if(root==null) return 0;
        return 1+ Size(root.left)+ Size(root.right);
    }
    private static int Levels(Node root){
        if(root==null) return 0;
        int a=Levels(root.left);
        int b=Levels(root.right);
        return 1+Math.max(a,b);
    }
    public static void main(String[] args) {
        Node a = new Node(1);//a is the root
        Node b=new Node(4);
        Node c=new Node(3);
        Node d=new Node(2);
        Node e=new Node(6);
        Node f=new Node(5);
        a.left=b;a.right=c;
        b.left=d;b.right=e;
        c.right=f;
        System.out.println(Sum(a));
        System.out.println(Product(a));
        System.out.println(Maximum(a));
        System.out.println(Size(a));
        System.out.println(Levels(a));

    }

}
