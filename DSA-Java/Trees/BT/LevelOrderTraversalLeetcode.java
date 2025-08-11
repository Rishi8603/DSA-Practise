package Trees.BT;

import Trees.Node;

import java.util.*;

public class LevelOrderTraversalLeetcode {
    Class Node;
    public static void main(String[] args) {
        Trees.Node a = new Node(1);//a is the root
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(6);
        Node g=new Node(7);
        a.left=b;a.right=c;
        b.left=d;b.right=e;
        c.left=f;c.right=g;
        System.out.println(levelOrder(a));
    }
    public static int Levels(Node root){
        if(root==null) return 0;
        int a=Levels(root.left);
        int b=Levels(root.right);
        return 1+Math.max(a,b);
    }
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list=new ArrayList<>();
        int lvl=Levels(root);
        for (int x = 0; x <=lvl-1; x++) {
            ArrayList<Integer> listI =new ArrayList<>();
            helper(root,0,x,listI);
            list.add(listI);
        }
        return list;
    }
    public static void helper(Node root, int level, int n, ArrayList<Integer> list){
        if(root==null) return ;//base case
        if(level>n) return;
        if(level==n) list.add(root.val);
        helper(root.left,level+1,n,list);//left subtree
        helper(root.right,level+1,n,list);//right subtree
    }
}
