package Trees.BT;

import Trees.Node;

public class SymmetricBInaryTree {
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
        System.out.println(isSymmetric(a));
    }
    public static boolean isSymmetric(Node root) {
        if(root==null) return true;
        int maxDepth=Integer.MAX_VALUE;
        return helper(root.left,root.right);
    }
    public static boolean helper(Node root1,Node root2){
        if (root1 == null && root2 == null) {
            return true;
        }
        if(root1==null || root2==null){
           return false;
        }
        if(root1.val!=root2.val) return false;
        return helper(root1.left,root2.right) &&helper(root1.right,root2.left);
    }
}
