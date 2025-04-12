package Stacks;

import java.util.ArrayList;
import java.util.*; //isse sb chz import ho jata hei

public class basicsofStack {
    public static void main(String[] args) {
        //int[] arr=new int[3];
        //ArrayList<Integer> list=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        st.push(5);
        st.push(34);
        st.push(33);
        st.push(32);
        //peek - it returns top most value of stack
        int q=st.peek();
        System.out.println(q);
    }
}
