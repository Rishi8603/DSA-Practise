package Stacks;

public class ArrayImplementation {
    public static class Stack{
        private int[] arr=new int[3];
        int idx=0;
        void push(int x){
            if(isFull()){
                System.out.println("stack is full");
                return;
            }
            arr[idx]=x;
            idx++;
        }
        int peek(){
            if(idx==0){
                System.out.println("khali hei stack");
                return -1;
            }
            return arr[idx-1];
        }
        int pop(){
            if(idx==0){
                System.out.println("khali hei");
                return -1;
            }
            int top=arr[idx-1];
            arr[idx-1]=0;
            idx--;
            return top;
        }
        void display(){
            for(int i=0;i<=idx-1;i++){
                System.out.print(arr[i]);
            }
            System.out.println();
        }
        int size(){
            return idx;
        }
        boolean isEmpty(){
            if(idx==0) return true;
            else return false;
        }
        boolean isFull(){
            if(idx==arr.length){
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {
       Stack st=new Stack();//khud ka ek object bnana hei
       st.push(4);
       st.display();
       st.push(5);
        st.display();
       st.push(1);
        st.display();
        System.out.println("size:"+st.size());
        st.pop();
        st.display();
        st.push(4);
        System.out.println(st.isFull());
        //abhi stack hmara full ho gya hei bcz array size 3 hi hei
        st.push(5);

    }
}
