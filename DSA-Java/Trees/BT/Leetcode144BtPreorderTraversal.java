package Trees.BT;
import Trees.Node;

import java.util.*;
import java.util.List;

public class Leetcode144BtPreorderTraversal {
    Node root;

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
        System.out.println(preorderTraversal(a));
    }

    static List<Integer> ans;

    private static void helper(Node root) {
        if (root == null) return;//base case
        ans.add(root.val);
        helper(root.left);//left subtree
        helper(root.right);//right subtree
    }

    public static List<Integer> preorderTraversal(Node root) {
        ans = new ArrayList<>();
        helper(root);
        return ans;
    }
}
