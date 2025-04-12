package Trees.BT;

import Trees.Node;

public class LcaOfBinaryTree {
    public static Class Node;
    public static Trees.Node lowestCommonAncestor(Node root, Node p, Node q){
        if(p==root||q==root) return root;
        boolean pLiesInLst =search(root.left,p);
        boolean qLiesInLst =search(root.left,q);
//        if(pLiesInLst ==true&& qLiesInLst==false){
//            return root;
//        }
//        if(pLiesInLst==false&&qLiesInLst==true){
//            return root;
//        }
        if(pLiesInLst==true&&qLiesInLst==true){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(pLiesInLst==false&&qLiesInLst==false){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }
    }
    public static boolean search(Node root,Node z){
        if(root==z) return true;
        if(root==null) return false;
        return search(root.left, z) || search(root.right, z);
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
        Node temp=lowestCommonAncestor(a,d,null);
        System.out.println(temp.val);
    }
}
