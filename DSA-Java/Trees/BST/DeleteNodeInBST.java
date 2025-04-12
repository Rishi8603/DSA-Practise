package Trees.BST;

import Trees.Node;

public class DeleteNodeInBST {
    public static void main(String[] args) {
        Node a=new Node(4);
        Node b=new Node(2);
        Node c=new Node(5);
        a.left=b;
        a.right=c;
        deleteNode(a,2);
    }
    public static Node deleteNode(Node root, int key) {
        if(root==null) return null;

        if(root.val==key){//DELETION 3cases banega
            //case 1 : 0 child node(leaf node)
            if(root.left==null && root.right==null) return null;
            //case 2 : 1 child node
            else if(root.left!=null&&root.right==null || root.left==null&&root.right!=null){
                if(root.left!=null && root.right==null){
                    return root.left;
                }else{
                    return root.right;
                }
            }
            //case 3 : 2 child node (Important)
            else if(root.left!=null && root.right!=null){
                Node pred=inorderPred(root);
                Node predParent=Parent(root,pred);

                // Re-linking for predecessor
                if (predParent == root) { // Special case: pred is root.left
                    pred.right = root.right;
                    return pred;
                }
                //pred ke right mein kuch nhi hoga i know
                //but left mein to kuch ho skta hei, that's why usko predParent ke right mein lga diye
                predParent.right=pred.left;
                pred.left=root.left;pred.right=root.right;
                return pred;
            }
        }
        else if(root.val>key){
            root.left=deleteNode(root.left,key);
        }
        else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }
        return root;
    }
    public static Node inorderPred(Node root){
        Node temp=root.left;
        while(temp.right!=null){
            temp=temp.right;
        }
        return temp;
    }
    public static Node Parent(Node root,Node pred){
        if(root.left==pred || root.right==pred) return root;
        Node temp=root.left;
        while(temp.right!=pred){
            temp=temp.right;
        }
        return temp;
    }
}
