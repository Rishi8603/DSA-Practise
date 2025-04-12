package LinkedList;

public class ReverseList {
    public static void displayrev(Node head){
        if(head==null){//base case
            return;
        }
        displayrev(head.next);
        System.out.print(head.val+" ");

    }
    public static Node reverseRec(Node head){
        if(head.next==null){//base case
            return head;
        }
        Node newHead = reverseRec(head.next);
        head.next.next=head;//interchanging connection
        head.next=null;
        return newHead;
    }
    public static Node reverseIterative(Node head){
        Node prev=null;
        Node current =head;
        Node after =null;
        while (current !=null) {
            after = current.next;
            current.next=prev;
            prev= current;
            current = after;
        }
        return prev;
    }
    public static void display(Node head){
        if(head==null){//base case
            return;
        }
        System.out.print(head.val+" ");
        display(head.next);
        System.out.println();
    }
    public static void main(String[] args) {
        Node a =new Node(3);
        Node b =new Node(5);
        Node c =new Node(1);
        Node d =new Node(2);
        Node e =new Node(4);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=null;
//        displayrev(a);
//        Node r=reverse(a);
        display(a);
//        a=reverseRec(a);
//        display(a);
        Node q=reverseIterative(a);
        display(q);

    }
}
