package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class prvSmallerElem {
    public static void main(String[] args) {
        int[] arr={2,1,4,5,1,3,3};
        int[] res=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        res[0]=-1;
        st.push(0);
        for (int i = 1; i < arr.length; i++) {
            while(st.size()>0 && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) {
                res[i]=-1;
            }
            else if(arr[i]>arr[st.peek()]){
                //indices store kr rhe hein
                res[i]=st.peek();
            }
            st.push(i);
        }
        System.out.println(Arrays.toString(res));
//        int[] arr={4,5,2,10,8};
//        int[] res=new int[arr.length];
//        Arrays.fill(res,-1);
//        Stack<Integer> st=new Stack<>();
//        st.push(0);
//        for (int i = 1; i < arr.length; i++) {
//            while(!st.isEmpty()&& arr[i]<arr[st.peek()]){
//                res[st.peek()]=arr[i];
//                st.pop();
//            }
//            st.push(i);
//        }
//        System.out.println(Arrays.toString(res));
    }
}
