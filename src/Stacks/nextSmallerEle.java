package Stacks;
import java.lang.reflect.Array;
import java.util.*;

public class nextSmallerEle {
    public static void main(String[] args) {
        int[] arr={5,2,4,6,3,5};
        int[] res=new int[arr.length];
        Arrays.fill(res,arr.length);
        Stack<Integer> st=new Stack<>();
        st.push(0);
        for (int i = 1; i < arr.length; i++) {
            while(!st.isEmpty()&& arr[i]<arr[st.peek()]){
                //indices store kro
                res[st.peek()]=i;
                st.pop();
            }
            st.push(i);
        }
        System.out.println(Arrays.toString(res));
    }
}
