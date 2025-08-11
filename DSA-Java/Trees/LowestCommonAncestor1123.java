package Trees;
import Trees.Node;
public class LowestCommonAncestor1123 {
    public static void main(String[] args) {
        Node root = buildManualTree();
        Node temp=lcaDeepestLeaves(root);
        System.out.println(temp.val);
    }
    public static Node buildManualTree() {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);

        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);

        root.left.right.left = new Node(7);
//        root.left.right.right = new Node(4);

        return root;
    }
    public static Node lcaDeepestLeaves(Node root) {
        return helper(0,root);
    }
    public static Node helper(int depth,Node root){
        int depthLeft=Levels(root.left)-1;
        int depthRight=Levels(root.right)-1;

        if(depthLeft>depthRight){
            return helper(depth+1,root.left);
        }else if(depthLeft<depthRight){
            return helper(depth+1,root.right);
        }else{//depthLeft==depthRight --> mtlb jhaan khada hei whi lca hei bhai
            return root;
        }
    }
    public static int Levels(Node root){
        if(root==null) return 0;
        int a=Levels(root.left);
        int b=Levels(root.right);
        return 1+Math.max(a,b);
    }
}
