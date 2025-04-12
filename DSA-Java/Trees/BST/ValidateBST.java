package Trees.BST;

import Trees.Node;

public class ValidateBST {
    Class Node;
    public static void main(String[] args) {
        Trees.Node a = new Node(5);//a is the root
        Node b=new Node(1);
        Node c=new Node(4);
        Node d=new Node(3);
        Node e=new Node(6);
        a.left=b;a.right=c;
        c.left=d;c.right=e;
        System.out.println(isValidBST(a));
    }
    public static boolean isValidBST(Node root) {
        if(root==null) return true;
        if(root.left!=null && root.val<=Maximum(root.left)) {
            return false;
        }
        if(root.right!=null && root.val >= Minimum(root.right)) {
            return false;
        }
        return isValidBST(root.left)  && isValidBST(root.right);
    }
    private static int Maximum(Node root){
        if(root==null) return Integer.MIN_VALUE;
        int a=Math.max(Maximum(root.left), Maximum(root.right));
        return Math.max(root.val,a);
    }
    private static int Minimum(Node root){
        if(root==null) return Integer.MAX_VALUE;
        int a=Math.min(Minimum(root.left), Minimum(root.right));
        return Math.min(root.val,a);
    }
}
