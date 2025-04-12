package Trees.BT;

import Trees.Node;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public static boolean hasPathSum(Trees.Node root, int targetSum){
        ArrayList<Integer> list=new ArrayList<>();
        helper(list,root,targetSum,0);
        if(list.contains(targetSum)) return true;
        return false;
    }
    public static List<Integer> helper(ArrayList<Integer> list, Node root,int target, int sum){
        if (root == null) {
            return list;
        }
        sum=sum+root.val;
        if (root.left == null && root.right == null) {
            list.add(sum);
            return list; // Return after adding the path for leaf node
        }
        if (root.left != null) {
            helper(list, root.left, target,sum);
        }
        if (root.right != null) {
            helper(list, root.right, target,sum);
        }
        return list;
    }
    public static Class Node;
    public static void main(String[] args) {
        Node a = new Node(1);//a is the root
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(6);
        Node g=new Node(7);
        Node h=new Node(8);
        Node i=new Node(9);
        Node j=new Node(10);
        Node k=new Node(11);
        Node l=new Node(12);
        Node m=new Node(13);
        Node n=new Node(14);
        Node o=new Node(15);
        a.left=b;a.right=c;
        b.left=d;b.right=e;
        c.right=g;c.left=f;
        d.left=h;d.right=i;
//        e.left=j;e.right=k;
        f.left=l;f.right=m;
//        g.left=n;g.right=o;
        System.out.println(hasPathSum(a,23));
    }
}
