package Stacks;

import java.util.*;

public class stockSpanGFG {
    public static void main(String[] args) {
        int[] arr={10, 4, 5, 90, 120, 80};
//        int[] res=new int[arr.length];
//        Stack<Integer> st=new Stack<>();
//        res[0]=1;
//        st.push(0);
//        for (int i = 1; i < arr.length; i++) {
//            while(st.size()>0 && arr[i]>arr[st.peek()]){
//                st.pop();
//            }
//            if(st.isEmpty()){
//                res[i]=i+1;
//            }else{
//                res[i]=i-st.peek();
//            }
//            st.push(i);
//        }
//        System.out.println(Arrays.toString(res));
        System.out.println(calculateSpan(arr));
    }
    public static ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> list=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        list.add(0,1);
        st.push(0);
        for (int i = 1; i < arr.length; i++) {
            while(st.size()>0 && arr[i]>arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                list.add(i,i+1);
//                res[i]=i+1;
            }else{
                list.add(i,i-st.peek());
//                res[i]=i-st.peek();
            }
            st.push(i);
        }
        return list;
    }
}
