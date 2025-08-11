package DP;

public class MaximumSubarray_KadanesAlgo {
    public static void main(String[] args) {
        int[] nums={-2,-3,4,-1,-2,1,5,-3};
        System.out.println(maxSubArray(nums));
    }

    static int maxSum;
    public static int maxSubArray(int[] nums) {
        maxSum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum<0){
                sum=0;
            }
            sum=sum+nums[i];
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum;
    }


}
