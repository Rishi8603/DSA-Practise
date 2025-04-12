package Stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementLeetcode496 {
    public static void main(String[] args) {
        int[] nums1={4,1,2};
        int[] nums2={1,3,4,2};
        System.out.println(Arrays.toString(check(nums1,nums2)));
    }
    public static int[] check(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] ans=new int[nums1.length];

        for(int num:nums2){
            while(!stack.empty() && stack.peek()<num){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }

        //now check in num1

        for (int i=0;i<nums1.length;i++){
            if(map.get(nums1[i])!=null) ans[i]=map.get(nums1[i]);
            else ans[i]=-1;
        }
        return ans;
    }

}
