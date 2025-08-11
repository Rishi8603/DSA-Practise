package Trees.BT;

import Trees.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueLevelOrderAlgalgLine {
    public static class Pair{
        Trees.Node node;
        int level;
        Pair(Node node,int level){
            this.node=node;
            this.level=level;
        }
    }
    Class Node;
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
        System.out.println(levelOrder(a));
    }
    public static List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> ans=new ArrayList<>();

        int lvl=Levels(root);
        for (int i = 0; i < lvl; i++) {
            List<Integer> arr=new ArrayList<>();
            ans.add(arr);
        }
        BFS(root,ans);
        return ans;
    }
    public static void BFS(Node root,List<List<Integer>> ans){
        Queue<Pair> q=new LinkedList<>();
        Pair p=new Pair(root,0);
        if(root!=null) q.add(p);
        while(q.size()>0){
            Pair front=q.remove();
            Node temp=front.node;
            int lvl=front.level;
//            ans.get(lvl).add(temp.val);
            //zig zag printing
            if(lvl%2==0) {
                ans.get(lvl).add(temp.val);
            }else{
                //mtlb ye 0 index pe add krega
                ans.get(lvl).add(0,temp.val);
            }
            if (front.node.left != null) q.add(new Pair(temp.left, lvl + 1));
            if (front.node.right != null) q.add(new Pair(temp.right, lvl + 1));
        }
    }
    public static int Levels(Node root){
        if(root==null) return 0;
        int a=Levels(root.left);
        int b=Levels(root.right);
        return 1+Math.max(a,b);
    }
}
