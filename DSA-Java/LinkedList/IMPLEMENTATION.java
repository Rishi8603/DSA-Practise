package LinkedList;

public class IMPLEMENTATION {

    public static class linkedlist{
        Node head=null; //user defined datatype
        Node tail=null;
        int size=0;
        void insertAtEnd(int val){
            Node temp=new Node(val);
            if(head==null){
                head=temp;
                tail=temp;
            }else{
                tail.next=temp;//tail ko connect kiye
                tail=temp;
            }
            size++;//see size wala function
        }
        void insertAtStart(int val){
            Node temp=new Node(val);
//            if(head==null){//empty list
//                head=temp;
//                tail=temp;
//            }
            if(head==null){
                insertAtEnd(val);//same kaam krega agr empty hei
            }
            else{//non-empty list
                temp.next=head;
                head=temp;
            }
            size++;//see size wala function
        }
        void insetAt(int idx,int val){
         Node t=new Node(val);
         Node temp=head;
            if(idx<0 || idx>size()){
                System.out.println("Wrong index");
                return;
            }
         if (idx==size()){
             insertAtEnd(val);
             return;
             //ab check kro, tail ab shi ayega
         }else if(idx==0){
             insertAtStart(val);
             return;
         }
            for (int i = 1; i <= idx-1; i++) {
                temp=temp.next;
            }
            t.next=temp.next;
            temp.next=t;//ho gya bhai kaam
        }
        int getAt(int idx){
            Node temp=head;
            for (int i = 1; i <=idx ; i++) {
                temp=temp.next;
            }
            return temp.val;
        }
        void deleteAt(int idx){
            Node temp=head;
            for (int i = 1; i <idx ; i++) {
                temp=temp.next;
            }
            if(idx==size()-1){
                tail=temp;
            }
            if(idx==0){
                head=head.next;
            }
            temp.next=temp.next.next;
        }
        void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.val+" ");
                temp=temp.next;
            }
            System.out.println();
        }
        int size(){
            //this is 0(n) so not good-
            //isliye pehle se ek int size class mein le lo
            //and jb bhi kuch inset kroge to size 1 se bdha lena
            //comment krdo niche sb ko
//            Node temp=head;
//            int count=0;
//            while(temp!=null){
//                count++;
//                //System.out.println(temp.data+" ");
//                temp=temp.next;
//            }
//            return count;
            return size;
        }
    }
    public static void main(String[] args) {
        linkedlist ll= new linkedlist();
        ll.insertAtEnd(4);  //4    head
        ll.insertAtEnd(5);
        ll.display();//4-5
        ll.insertAtEnd(12);
        ll.display();
        ll.insertAtStart(20);
        ll.display();//20-4-5-12
        ll.insetAt(2,11);
        ll.display();//20-4-11-5-12
        ll.insetAt(5,19);//insertAtEnd wala condition
        ll.display();//20-4-11-5-12
        System.out.println(ll.tail.val);
        ll.insetAt(0,1);//insetAtStart wala condition
        ll.display();//1- 20- 4- 11- 5- 12
        ll.insetAt(-2,1);
        ll.insetAt(10,10);
        System.out.println(ll.getAt(3));
//        ll.deleteAt(2);
//        ll.display();
//        ll.deleteAt(0);
//        ll.display();
        ll.deleteAt(5);
        ll.display();
        //  System.out.println(ll.size()); //sari size print ho jani chahiye
    }
}
