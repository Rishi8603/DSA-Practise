package LinkedList;

public class midElemOneTrav {

    public static int middle(Node head){
        Node slow=head;
        Node fast=head;
        while(fast.next!=null){
            fast=fast.next;
            if(fast.next==null){
                return slow.val;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return slow.val;
    }

    public static void main(String[] args) {
        Node a = new Node(4);
        Node b = new Node(5);
        Node c = new Node(55);
        Node d = new Node(7);
        Node e = new Node(65);
        Node f = new Node(36);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        System.out.println(middle(a));
    }

    }
