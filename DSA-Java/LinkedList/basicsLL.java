package LinkedList;

public class basicsLL {
    public static void insertatEnd(Node head, int val){
        Node temp=new Node(val);
        Node t=head;
        while(t.next!=null){
            t=t.next;
        }
        t.next=temp;
    }
    public static void display(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        //without temp variable
//        while(head!=null){
//            System.out.print(head.data+" ");
//            head=head.next;
//        }
//       while(head!=null){//ye wala loop nhi chalega
//            System.out.print(head.data+" ");
//            head=head.next;
//        }

    }

    public static class Node{
        int data; //value
        Node next; //address of next node
        Node(int data){
            this.data=data;
        }
    }
    public static void main(String[] args) {
        Node a=new Node(5);
        //System.out.println(a.next);
        Node b=new Node(6);
        Node c=new Node(6);
        Node d=new Node(7);
        Node e=new Node(8);
       //5 6 7 8 9
        a.next=b;//5->6 7 8 9
        System.out.println(a);//output-$Node@5f184fc6
        System.out.println(a.next);//output-$Node@3feba861
        System.out.println(b);//output-$Node@3feba861
        System.out.println(c);//output-$Node@5b480cf9
        b.next=c;  //5->6->7 8 9
        c.next=d;  //5->6->7->8 9
        d.next=e;  //5->6->7->8->9
        //CASE A
       // display(a);
        //display(a);//yhaan lekin do br print ho jayega bcz function ko 2 br chla rhe hein

        //CASE B
        //whi agr yhaan do br while loop without temp chalaye then 2 br print nhi ho ga
//        while(a!=null){
//            System.out.print(a.data+" ");
//            a=a.next;
//        }
//        while(a!=null){//do br print nhi ho ga
//            System.out.print(a.data+" ");
//            a=a.next;
//        }
        insertatEnd(a,87);
        display(a);
//        System.out.println(a.next.data); //3 print hoga bcz a.next b hei and uska data 3
//        Node temp=a;
//        for (int i = 0; i < 5; i++) {
//            System.out.println(temp.data);
//            temp=temp.next; //most important line
//        }
    }
}
