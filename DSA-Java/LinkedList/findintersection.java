package LinkedList;

public class findintersection {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        //ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode intersection(ListNode headA, ListNode headB){
        ListNode temp1a = headA;
        ListNode temp1b = headA;
        ListNode temp2a = headB;
        ListNode temp2b = headB;
        int size1=0;
        int size2=0;
        while(temp1a !=null){
            size1++;
            temp1a = temp1a.next;
        }
        while(temp2a !=null){
            size2++;
            temp2a = temp2a.next;
        }
        int result = size1 - size2;
        int size = Math.abs(result);
        for (int i = 0; i <size; i++) {
            if(size2>size1){
                temp2b = temp2b.next;
            }else if(size1>size2){
                temp1b = temp1b.next;
            }
        }
        while(temp1b !=null && temp2b !=null){
            if(temp1b == temp2b){
                return temp2b;
            }
            temp1b = temp1b.next;
            temp2b = temp2b.next;

        }
        return null;
    }
    public static void display(ListNode head1, ListNode head2,ListNode head3){
       ListNode temp1=head1;
       ListNode temp2=head2;
        ListNode temp3=head3;
        while(temp1!=temp3){
            System.out.print(temp1.val+" ");
            temp1=temp1.next;
        }
        System.out.println();
        System.out.print("      ");
        while(temp3!=null){

            System.out.print(temp3.val+" ");
            temp3=temp3.next;
        }
        System.out.println();
        while(temp2!=head3){
            System.out.print(temp2.val+" ");
            temp2=temp2.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(4);
        ListNode a2=new ListNode(1);

        ListNode b1=new ListNode(5);
        ListNode b2=new ListNode(6);
        ListNode b3=new ListNode(1);

        ListNode c1=new ListNode(8);
        ListNode c2=new ListNode(4);
        ListNode c3 =new ListNode(5);

        a1.next=a2;
        a2.next=c1;

        b1.next=b2;
        b2.next=b3;
        b3.next=c1;

        c1.next=c2;
        c2.next= c3;
//        display(a1,b1,c1);
        System.out.println(intersection(a1,b1));
//        ListNode q=intersection(a1);
//        System.out.println(q.val);
    }
}
