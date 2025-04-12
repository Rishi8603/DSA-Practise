package LinkedList;

public class midElemOneTrav {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        //ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static int middle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
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
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(55);
        ListNode d = new ListNode(7);
        ListNode e = new ListNode(65);
        ListNode f = new ListNode(36);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        System.out.println(middle(a));
    }

    }
