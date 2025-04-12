package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class prevGreaterElement {
    public static void main(String[] args) {
        int[] arr={100,80,60,70,60,75,85};
        int[] res=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        res[0]=-1;
        st.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            while(st.size()>0 && arr[i]>st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=-1;
            }else{
                res[i]=st.peek();
            }
            st.push(arr[i]);
        }
        System.out.println(Arrays.toString(res));
    }
}
