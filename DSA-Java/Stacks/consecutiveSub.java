package Stacks;

import java.util.*;

public class consecutiveSub {
    public static Stack<Integer> check(int[] arr){
        Stack<Integer> st=new Stack<>();
        int i = 0;
        while ( i < arr.length) {
            if(st.isEmpty()){
                st.push(arr[i]);
            }else if(st.peek()!=arr[i]){
                st.push(arr[i]);
            }else if(st.peek()==arr[i]){
                if(i==arr.length-1){
                    st.pop();
                }else if(arr[i]!=arr[i+1]  ){
                    st.pop();
                }
            }
            i++;
        }
        return st;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,3,4,4,4,2,2,6,10,10,10,5,7,7,2,2};
        System.out.println(check(arr));
    }
}
