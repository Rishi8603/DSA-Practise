package LinkedList;

public class cyclicll {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        //ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static boolean check(ListNode head){
        if(head==null){
            return false;
        }
        if(head.next==null){//1 hi element rha then
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null){
            //dekh agr cycle rha then fast kbhi null nhi hoga, and wo kbhi na kbhi slow ke brabar hoga,
            //jb fast=slow hoga then return true
            //ar agr cycle nhi rha then to normal chalega loop
            slow=slow.next;
            if(slow==null){//if slow hi null ho gya then
                return false;
            }
            if(fast.next==null){//if fast.next null ho gya then
                return false;
            }
            fast=fast.next.next;
            if(fast==slow){
                return true;
            }
        }

        return false;
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
        System.out.println(check(a));
    }

}
