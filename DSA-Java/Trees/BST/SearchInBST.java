package Trees.BST;

import Trees.Node;

import java.util.LinkedList;
import java.util.Queue;

public class SearchInBST {
    public static void main(String[] args) {
        Node a = new Node(4);//a is the root
        Node b=new Node(2);
        Node c=new Node(7);
        Node d=new Node(1);
        Node e=new Node(3);
        a.left=b;a.right=c;
        b.left=d;b.right=e;
        Node x=searchBST(a,2);
        levelOrder(x);
    }
    public static Node searchBST(Node root, int val) {
        if(root==null) return null;
        if(val==root.val) {
//            Node temp=new Node(root.val);
//            temp.left=searchBST(root.left,val);
//            temp.right=searchBST(root.right,val);
            return root;
        }
        if(val>root.val){
           return searchBST(root.right,val);
        }else{
           return searchBST(root.left,val);
        }
    }
    private static void levelOrder(Node root){
        Queue<Node> q=new LinkedList<>();
        if(root!=null) q.add(root);
        while(q.size()>0){
            Node front=q.remove();
            System.out.print(front.val+" ");
            if(front.left!=null) q.add(front.left);
            if(front.right!=null) q.add(front.right);
        }
    }
}
