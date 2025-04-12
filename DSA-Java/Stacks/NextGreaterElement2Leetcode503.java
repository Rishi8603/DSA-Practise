package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2Leetcode503 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(arr)));
    }
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int[] res=new int[nums.length];
        Arrays.fill(res,-1);
        st.push(0);
        int n=nums.length;
        for (int i =1; i < 2*nums.length  ; i++) {
            while(st.size()>0 && nums[st.peek()]<nums[i%n]){
                res[st.peek()]=nums[i%n];
                st.pop();
            }
            st.push(i%n);
        }
        return res;
    }
}
