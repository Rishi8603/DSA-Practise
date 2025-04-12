package LinkedList;

public class nthNodeDelfromEnd {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        //ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode findNthnode(ListNode head,int m){
        ListNode slow=head;
        ListNode fast=head;
        for (int i = 0; i < m; i++) {
            fast=fast.next;
        }
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {//function
        ListNode slow=head;
        ListNode fast=head;
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }
        if(fast==null){
            head=head.next;
            return head;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
//        if(n==)
        slow.next=slow.next.next;
        return head;
    }
    public static void display(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode a=new ListNode(4);
        ListNode b=new ListNode(5);
        ListNode c=new ListNode(55);
        ListNode d=new ListNode(7);
        ListNode e=new ListNode(65);
        ListNode f=new ListNode(36);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;

        System.out.println(findNthnode(a,1).val);
        display(a);
        ListNode q=removeNthFromEnd(a,6);
        display(q);

//        System.out.println(ans);
    }
}
