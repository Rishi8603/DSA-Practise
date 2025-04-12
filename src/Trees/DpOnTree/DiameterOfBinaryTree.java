package Trees.DpOnTree;
import Trees.BST.PredAndSuccGFG;
import Trees.Node;
public class DiameterOfBinaryTree {
    Class Node;
    public static void main(String[] args) {

    }
    static int res;
    public static int diameterOfBinaryTree(Node root) {
        res=Integer.MIN_VALUE;
        helper(root);
        return res;
    }
    public static int helper(Node root){
        //base cond
        if(root==null) return 0;

        //hypothesis
        int l=helper((root.left));
        int r=helper((root.right));

        //induction
        int temp=1+Math.max(l,r);
//        int ans=Math.max(l+r,temp); aditya verma code
// abv line is not neccessary bcz l+r is always greater than temp
//        res=Math.max(ans,res);
        res=Math.max(l+r,res);
        return temp;
    }
}
