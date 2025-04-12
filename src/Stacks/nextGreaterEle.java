package Stacks;

import java.util.*;

public class nextGreaterEle {
    public static void main(String[] args) {
        int[] arr={1,3,2,1,8,6,3,4};
        //1 ka next greater 3, 3 ka next greater 8 , similarly 8 ka next greater kuch nhi
        int[] res=new int[arr.length];
        res[arr.length-1]=-1;
        Stack<Integer> st=new Stack<>();
        st.push(arr[arr.length-1]);
        for (int i = arr.length-2; i >=0 ; i--) {
            while(st.size()>0 && arr[i]>st.peek()){
                st.pop();
            }
            if(st.isEmpty()) res[i]=-1;
            else res[i]=st.peek();
            st.push(arr[i]);
        }
        System.out.println(Arrays.toString(res));
//        for (int i = 0; i < arr.length; i++) {
//            res[i]=-1;
//            for (int j = i+1; j < arr.length; j++) {
//                if(arr[j]>arr[i]){
//                    res[i]=arr[j];
//                    break;//inner loop tut jayega,outer nhi
//                }
//            }
//        }
//      System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(res));
    }
}
