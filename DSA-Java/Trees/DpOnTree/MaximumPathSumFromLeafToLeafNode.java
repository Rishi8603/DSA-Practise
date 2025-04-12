package Trees.DpOnTree;

import Trees.Node;

public class MaximumPathSumFromLeafToLeafNode {
    Class Node;
    public static void main(String[] args) {

    }
    static int res;

    public static int maxPathSum(Node root) {
        res = Integer.MIN_VALUE;
        int temp = helper(root);

        // If `res` was never updated (happens in single-node/skewed trees), return `temp`
        return (res == Integer.MIN_VALUE) ? temp : res;
    }

    public static int helper(Node root) {
        // Base case
        if (root == null) return 0;

        // Hypothesis: Compute max sum from left and right subtree
        int l = helper(root.left);
        int r = helper(root.right);

        // If both children exist, update `res` for a valid leaf-to-leaf path
        if (root.left != null && root.right != null) {
            res = Math.max(res, l + r + root.val);
            return Math.max(l, r) + root.val;
        }

        // If only Main child exists, return sum through that child
        if (root.left == null) return r + root.val;
        return l + root.val;
    }
}
