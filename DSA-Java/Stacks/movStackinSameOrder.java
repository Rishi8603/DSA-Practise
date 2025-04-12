package Stacks;

import java.util.Stack;
import java.util.*;

public class movStackinSameOrder {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Stack<Integer> st=new Stack<>();
//        int n;
//        System.out.println("Enter no. of elements:");
//        n=sc.nextInt();
//        for (int i = 0; i <n ; i++) {//input lene ke liye
//            int x=sc.nextInt();
//            st.push(x);
//        }
        st.push(3);
        st.push(2);
        st.push(1);
        st.push(44);
        st.push(7);
        System.out.println(st);
        //reverse order
        Stack<Integer> rt=new Stack<>();
        while(st.size()>0){
            //int x=st.peek();
            rt.push(st.pop()); //direct
            //st.pop();
        }
        System.out.println(rt);
        //now reverse rt stack and move this in gt stack
        Stack<Integer> gt=new Stack<>();
        while(rt.size()>0){
            //int x=st.peek();
            gt.push(rt.pop()); //direct
            //st.pop();
        }
        System.out.println(gt);
    }
}
