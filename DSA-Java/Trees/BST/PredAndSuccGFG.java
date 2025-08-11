package Trees.BST;

import Trees.Node;

public class PredAndSuccGFG {
    public static void main(String[] args) {
        Node a=new Node(5);
        Node b=new Node(2);
        Node c=new Node(8);
        Node d=new Node(1);
        Node e=new Node(4);
        Node f=new Node(6);
        Node g=new Node(9);
        a.left=b;a.right=c;b.left=d;b.right=e;c.left=f;c.right=g;
        Node[] pre = new Node[1];
        Node[] suc = new Node[1];

        Find(a,pre,suc,5);
        System.out.println(pre[0].val);
        System.out.println(suc[0].val);
    }

    public static void Find(Node root, Node[] pre, Node[] suc, int key) {
        pre[0] = null;
        suc[0] = null;
        Node temp = root;
        //find predecessor
        while (temp != null) {
            if (temp.val < key) {
                pre[0] = temp;
                temp = temp.right;  // Move right to find a closer predecessor
            } else {
                temp = temp.left;
            }
        }
        //find successor
        temp = root;
        while (temp != null) {
            if (temp.val > key) {
                suc[0] = temp;
                temp = temp.left;  // Move left to find a closer successor
            } else {
                temp = temp.right;
            }
        }
    }
}

    //SASTA METHOD
//    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
//        ArrayList<Node> list=new ArrayList<>();
//        inorder(root,list);
//        for (int i = 0; i < list.size(); i++) {
//            if(i!=0 && i!=list.size()-1 && list.get(i).val==key){
//                pre[0]=list.get(i-1);
//                suc[0]=list.get(i+1);
//            }else if(i==0){
//                pre[0]=null;
//                suc[0]=list.get(i+1);
//            }else if(i==list.size()-1){
//                pre[0]=list.get(i-1);
//                suc[0]=null;
//            }
//        }
//    }
//    public static void inorder(Node root, ArrayList<Node> list){
//        if(root==null) return;//base case
//
//        inorder(root.left,list);//left subtree
//        list.add(root);
//        inorder(root.right,list);//right subtree
//    }

