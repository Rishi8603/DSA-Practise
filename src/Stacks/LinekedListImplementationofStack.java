package Stacks;

public class LinekedListImplementationofStack {
    public static class Node{//user defined data type
        int val;
        Node next;
        Node(int val){
            this.val=val;
        }
    }
    public static class LLStack {//user defined data structure
        Node head=null;
        private int size=0;
        void push(int n){
            Node temp=new Node(n);
            temp.next=head;
            head=temp;
            size++;
        }
        void displayRev(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.val+" ");
                temp=temp.next;
            }
            System.out.println();
        }
        void displayRec(Node h){
            if(h==null) return;
            displayRec(h.next);
            System.out.print(h.val+" ");
        }
        void display(){
            displayRec(head);
            System.out.println();
        }
        int size(){//getter
            return size;
        }
        int pop() {
            if (head == null) {
                System.out.println("stack is empty");
                return -1;
            }
            int x=head.val;
            head=head.next;
            return x;
        }
        int peek(){
            if (head == null) {
                System.out.println("stack is empty");
                return -1;
            }
            return head.val;
        }
        boolean isEmpty (){
            if(size==0) return true;
            return false;
        }
    }

    public static void main(String[] args) {

        LLStack st=new LLStack();
        st.push(4);
        st.push(8);
        st.push(3);
        //now we want output 4 48 34
        st.displayRev();
        st.display();
        st.push(7);
        st.pop();
        System.out.println(st.peek());
        st.isEmpty();


    }
}
