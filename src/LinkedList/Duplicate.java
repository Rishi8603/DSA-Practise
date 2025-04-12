package LinkedList;
public class Duplicate {
    public static void main(String[] args) {
        Node a=new Node(1);
        Node b=new Node(1);
        Node c=new Node(2);
//        Node d=new Node(2);
//        Node e=new Node(3);
//        Node f=new Node(5);
//        Node g=new Node(5);
        a.next=b;b.next=c;
//        c.next=d;d.next=e;e.next=f;f.next=g;
        display(a);
        System.out.println();
        deleteDuplicates(a);
        display(a);
    }
    public static Node deleteDuplicates(Node head) {
        Node slow =head;
        Node fast =head;
        while (fast != null) {
            if(slow.next!=null && slow.next.val== slow.val){
                while( fast!=null && slow.val== fast.val ){
                    fast=fast.next;
                }
                if(fast==null) slow.next=null;
                else {
                    slow.next = fast;
                    slow = slow.next;
                }
            }
            else{
                slow=slow.next;
                fast=fast.next;
            }
        }
        return head;
    }
    public static void display(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
    }
}
