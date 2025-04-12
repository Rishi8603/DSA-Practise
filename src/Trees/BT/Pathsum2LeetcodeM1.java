package Trees.BT;

import Trees.Node;

import java.util.ArrayList;
import java.util.List;

public class Pathsum2LeetcodeM1 {
    public static Class Node;
    public static void main(String[] args) {
        Trees.Node a = new Node(1);//a is the root
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(6);
        Node g=new Node(7);
        a.left=b;a.right=c;
//        b.left=d;
        b.right=e;
        System.out.println(hasPathSum2(a,8));
    }
    public static List<List<Integer>> hasPathSum2(Node root, int targetSum){
        List<List<Integer>> list=new ArrayList<>();
        if (root == null) return list;
        ArrayList<Integer> arr=new ArrayList<>();
        helper(list,root,targetSum,0,arr);
        return list;
    }
    public static void helper(List<List<Integer>> list, Node root, int target, int sum,ArrayList<Integer> arr){
        if (root == null) return;

        sum=sum+root.val;
        arr.add(root.val);
        if (root.left == null && root.right == null) {
            if(target==sum){
                ArrayList<Integer> nlist=new ArrayList<>();
                for (int i = 0; i < arr.size(); i++) {
                    nlist.add(arr.get(i));
                }
                list.add(nlist);
            }
            arr.remove(arr.size()-1);
            return;
        }
        if (root.left != null) {
            helper(list, root.left, target,sum,arr);
        }
        if (root.right != null) {
            helper(list, root.right, target,sum,arr);
        }
        arr.remove(arr.size()-1);
    }
}
