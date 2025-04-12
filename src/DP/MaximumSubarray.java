package DP;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    static int maxSum;
    public static int maxSubArray(int[] nums) {
        helper(nums,nums.length-1);
        return maxSum;
    }
    public static int helper(int[] nums,int n){
        //base case
        if(n==0){
            maxSum=nums[0];
            return nums[0];
        }

        //main code
        int prev=helper(nums,n-1);
        int current=Math.max(nums[n],nums[n]+prev);
        maxSum=Math.max(maxSum,current);
        return current;
    }

}
