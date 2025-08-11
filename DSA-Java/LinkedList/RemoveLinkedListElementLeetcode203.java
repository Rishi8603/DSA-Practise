package LinkedList;

public class RemoveLinkedListElementLeetcode203 {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(2);
        Node d = new Node(1);
//        Node e = new Node(4);
//        Node f = new Node(5);
//        Node g = new Node(6);


        a.next = b;
        b.next = c;
        c.next = d;
//        d.next = e;
//        e.next=f;
//        f.next=g;

        Node temp=removeElements(a,2);
        while(temp!=null){
            System.out.print(temp.val + " ");
            temp=temp.next;
        }
    }
    public static Node removeElements(Node head, int val) {
        if(head==null) return null;
        while(head!=null && head.val==val){
            head=head.next;
        }

        Node temp1=head;
        while(temp1!=null && temp1.next != null){
            if (temp1.next.val == val) {
                temp1.next = temp1.next.next; // Skip the node
            } else {
                temp1 = temp1.next;
            }
        }
        return head;
    }
}
