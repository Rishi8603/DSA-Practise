package LinkedList;

public class findintersection {
    public static Node intersection(Node headA, Node headB){
        Node temp1a = headA;
        Node temp1b = headA;
        Node temp2a = headB;
        Node temp2b = headB;
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
    public static void display(Node head1, Node head2,Node head3){
        Node temp1=head1;
        Node temp2=head2;
        Node temp3=head3;
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
        Node a1=new Node(4);
        Node a2=new Node(1);

        Node b1=new Node(5);
        Node b2=new Node(6);
        Node b3=new Node(1);

        Node c1=new Node(8);
        Node c2=new Node(4);
        Node c3 =new Node(5);

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
