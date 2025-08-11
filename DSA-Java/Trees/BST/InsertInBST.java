package Trees.BST;

import Trees.Node;

import java.util.LinkedList;
import java.util.Queue;

public class InsertInBST {
    Class Node;
    public static void main(String[] args) {
        Trees.Node a = new Node(4);//a is the root
        Node b=new Node(2);
        Node c=new Node(7);
        Node d=new Node(1);
        Node e=new Node(3);
        a.left=b;a.right=c;
        b.left=d;b.right=e;
        levelOrder(insertIntoBST(a,5));
    }
    public static Node insertIntoBST(Node root, int val) {
        if(root==null){
            Node temp=new Node(val);
            return temp;
        }
        if(val>root.val){
            if(root.right==null){
                Node temp=new Node(val);
                root.right=temp;
                return root;
            }else{
                return insertIntoBST(root.right,val);
            }
        }
        else if(val<root.val){
            if(root.left==null){
                Node temp=new Node(val);
                root.left=temp;
            }else{
               return insertIntoBST(root.left,val);
            }
        }
        return root;
    }
    public static void levelOrder(Node root){
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
