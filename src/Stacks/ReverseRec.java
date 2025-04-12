package Stacks;

import java.util.Stack;

public class ReverseRec {
    public static void reverse(Stack<Integer> st){
        if(st.size()==1){
            return;
        }
        int top=st.pop();
        reverse(st);
        insertAtBottom(st, top);
    }
    public static void insertAtBottom(Stack<Integer> st, int element){
        if(st.size()==0){
            st.push(element);
            return;
        }
        int x=st.pop();
        insertAtBottom(st,element);
        st.push(x);
        return;
    }
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
//        System.out.println(st);
//        displayRec(st);
//        System.out.println(st); //pass by reference
//        System.out.println();
        System.out.println(st);
        reverse(st);
        System.out.println(st);

    }
}
