package Trees.BST;

import Trees.Node;

import java.util.ArrayList;

public class MinimumDistanceBetweenBSTNodes {
    public static void main(String[] args) {
        Node a = new Node(27); // Root
        Node b = new Node(34);
        Node c = new Node(58);
        Node d = new Node(50);
        Node e = new Node(44);

        // Connect nodes to form the binary tree (linked-list like structure)
        a.right = b;
        b.right = c;
        c.left = d;
        d.left = e;
        System.out.println(minDiffInBST(a));
    }
    public static int minDiffInBST(Node root) {
        ArrayList<Integer> list=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        Node curr=root;
        while(curr!=null){
            if(curr.left!=null){
                //pred
                Node pred=curr.left;
                while(pred.right!=null && pred.right!=curr){
                    pred=pred.right;
                }
                //link
                if(pred.right==null){
                    pred.right=curr;
                    curr=curr.left;
                }
                //unilink
                else{
                    if(list.size()!=0 && (curr.val-list.get(list.size()-1))<min){
                        min=curr.val-list.get(list.size()-1);
                        list.add(curr.val);
                    }else{
                        list.add(curr.val);
                    }
                    pred.right=null;
                    curr=curr.right;
                }
            }else{
                if(list.size()!=0 && (curr.val-list.get(list.size()-1))<min){
                    min=curr.val-list.get(list.size()-1);
                    list.add(curr.val);
                }else{
                    list.add(curr.val);
                }
                curr=curr.right;
            }
        }
        return min;
    }
}
