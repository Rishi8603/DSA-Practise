package Backtracking;

import java.util.*;

public class PermutationLeetcode46 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(permute(nums));
    }
    public static  List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
//        List<Integer> ds=new ArrayList<>();
//        boolean[] isVis=new boolean[nums.length];
        helper(nums,0,ans);
        return ans;
    }
    public static void helper(int[] nums,int idx,List<List<Integer>> ans){
        if(idx==nums.length-1){
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                l.add(nums[i]);
            }
            ans.add(l);
            return;
        }
        for(int i=idx;i<nums.length;i++){//imp -> i=idx se loop chalao
            if(i!=idx) swap(i,idx,nums);
            helper(nums,idx+1,ans);
            //now backtrack
            swap(i,idx,nums);
        }
    }
    public static void swap(int i,int idx,int[] nums){
        int temp=nums[i];
        nums[i]=nums[idx];
        nums[idx]=temp;
    }
}
