package Trees.BT;

import Trees.Node;

public class BalancedBinaryTree {
    Class node;
    public static void main(String[] args) {
        Node a = new Node(1);//a is the root
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(6);
        Node g=new Node(7);
        a.left=b;a.right=c;
        b.left=d;b.right=e;
        c.left=f;c.right=g;
        System.out.println(isBalanced(a));
    }
    public static boolean isBalanced(Node root) {
        boolean[] ans={true};
        Levels(root,ans);//time comp=O(n)
        return ans[0];
    }
    public static int Levels(Node root,boolean[] ans){
        if(root==null) return 0;
        int leftLevels=Levels(root.left,ans);
        int rightLevels =Levels(root.right,ans);
        int diff=Math.abs(leftLevels-rightLevels);
        if(diff>1) ans[0]=false;
        return 1+Math.max(leftLevels, rightLevels);
    }
}
