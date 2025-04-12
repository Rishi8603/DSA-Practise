package LinkedList;

public class findCycleNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        //ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode find(ListNode head){
        if(head==null){
            return null;
        }
        if(head.next==null){//1 hi element rha then
            return null;
        }

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null) {
            slow = slow.next;
//            if(slow==null){
//                return ;
//            }
//            if(fast.next==null){/
//                return ;
//            }
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        ListNode temp=head;
        if(fast!=null) {
            while (temp != slow) {
                temp = temp.next;
                slow = slow.next;
            }
            return slow;
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode a=new ListNode(3);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(0);
        ListNode d=new ListNode(-4);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=b;
        System.out.println(find(a));
    }
}
