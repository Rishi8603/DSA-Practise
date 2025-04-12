package LinkedList;

public class delMidElem {
    public static Node delete(Node head){
        Node slow=head;
        Node fast=head;
        while(fast.next.next!=null && fast.next.next.next!=null){
            fast=fast.next;
            slow=slow.next;
            fast=fast.next;
        }

        slow.next=slow.next.next;
        return head;
    }
    public static void display(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node a = new Node(4);
        Node b = new Node(5);
        Node c = new Node(55);
        Node d = new Node(7);
        Node e = new Node(65);
        Node f = new Node(36);
//        ListNode g = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
//        f.next = g;
        display(a);
        System.out.println();
        Node q=delete(a);
        display(q);

    }
}
