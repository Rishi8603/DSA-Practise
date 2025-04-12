package Trees;

import java.util.ArrayList;
import java.util.List;

public class prac {
    public static void main(String[] args) {
        Node a=new Node(4);
        Node b=new Node(2);
        Node c=new Node(6);
        Node d=new Node(1);
        Node e=new Node(3);
        a.left=b;
        a.right=c;
        b.left=d;b.right=e;
        System.out.println(isValidBST(a));
    }
    public static boolean isValidBST(Node root) {
        ArrayList<Integer> list=new ArrayList<>();
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
                    if(list.size()!=0 && list.get(list.size()-1)>curr.val){
                        return false;
                    }else{
                        list.add(curr.val);
                    }
                    pred.right=null;
                    curr=curr.right;
                }
            }else{
                if(list.size()!=0 && list.get(list.size()-1)>=curr.val){
                    return false;
                }else{
                    list.add(curr.val);
                }
                curr=curr.right;
            }
        }
        return true;
    }
}
