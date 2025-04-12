package Stacks;

import java.util.*;

public class nextGreaterEleM2 {
    public static void main(String[] args) {
        int[] arr={1,3,2,1,8,6,3,4};
        int[] res=new int[arr.length];
        Arrays.fill(res, -1);
        Stack<Integer> st=new Stack<>();
        st.push(0);
        for (int i = 1; i < arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                res[st.peek()]=arr[i];
                st.pop();
            }
            st.push(i);
        }
        System.out.println(Arrays.toString(res));
    }
}
