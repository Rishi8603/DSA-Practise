package LeetcodeDaily;

import java.util.Arrays;
import java.util.HashMap;

public class BitManipulation2419 {
    public static void main(String[] args) {
        int[] arr={378034, 378034, 378034};
        System.out.println(longestSubarray(arr));
    }
    public static int longestSubarray(int[] nums) {
        int n=nums.length;
        int[] nums1=Arrays.copyOf(nums,nums.length);
        System.out.println(Arrays.toString(nums1));
        Arrays.sort(nums1);
        int max=nums1[n-1];
        int count=0;
        int maxCount=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==max && nums[i+1]==max){
                count++;
            }else{
                maxCount=Math.max(count,maxCount);
                count=0;
            }
        }
        return Math.max(maxCount,count)+1;
    }
}
