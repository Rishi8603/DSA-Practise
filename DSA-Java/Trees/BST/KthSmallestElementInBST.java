package Trees.BST;

import Trees.Node;

import java.util.ArrayList;

public class KthSmallestElementInBST {
    public static void main(String[] args) {
        Node a = new Node(5);//a is the root
        Node b=new Node(1);
        Node c=new Node(4);
        Node d=new Node(3);
        Node e=new Node(6);
        a.left=b;a.right=c;
        c.left=d;c.right=e;
        System.out.println(kthSmallest(a,3));
    }
    public static int kthSmallest(Node root, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        inorder(root,list);
        System.out.println(list);
        return list.get(k-1);
    }
    public static void inorder(Node root,ArrayList<Integer> list){
        if(root==null) return;//base case

        inorder(root.left,list);//left subtree
        list.add(root.val);
        inorder(root.right,list);//right subtree
    }
}
