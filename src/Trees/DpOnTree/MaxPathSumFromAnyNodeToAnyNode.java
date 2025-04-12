package Trees.DpOnTree;
import Trees.Node;
public class MaxPathSumFromAnyNodeToAnyNode {
    Class Node;
    public static void main(String[] args) {

    }
    static int res;
    public static int maxPathSum(Node root) {
        res=Integer.MIN_VALUE;
        helper(root);
        return res;
    }
    public static int helper(Node root){
        //base cond
        if(root==null) return 0;

        //hypothesis
        // Recursively find max sum from left and right subtree
        int l = Math.max(0, helper(root.left));  // Ignore negative paths
        int r = Math.max(0, helper(root.right)); // Ignore negative paths

        //induction
        int temp=Math.max(Math.max(l,r)+root.val,root.val);
//        int ans=Math.max(l+r+root.val,temp); aditya verma code
// abv line is not neccessary bcz l+r+root.val is always greater than temp
//        res=Math.max(ans,res);
        res=Math.max(l+r+root.val,res);
        return temp;
    }
}
