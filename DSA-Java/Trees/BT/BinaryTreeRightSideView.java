package Trees.BT;

import Trees.Node;

import java.util.*;

public class BinaryTreeRightSideView {
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
//        a.left=b;a.right=c;
//        b.left=d;
//        d.left=e;
        System.out.println(rightSideView(a));
    }
    public static ArrayList<Integer> rightSideView(Node root) {
        ArrayList<Integer> list=new ArrayList<>();
        int lvl=Levels(root);
        if(root==null) return list;
        for (int x = 0; x < lvl; x++) {
            List<Integer> list3 =new ArrayList<>();
            nthLevel(root,0,x, list3);
            int temp= list3.size()-1;
            list.add(list3.get(temp));
        }
        return list;
    }

    public static void  nthLevel(Node root,int level,int n,List<Integer> list){
        if(root==null) return ;//base case
        if(level==n) list.add(root.val);
        nthLevel(root.left,level+1,n,list);//left subtree
        nthLevel(root.right,level+1,n,list);//right subtree
    }
    public static int Levels(Node root){
        if(root==null) return 0;
        int a=Levels(root.left);
        int b=Levels(root.right);
        return 1+Math.max(a,b);
    }
}
