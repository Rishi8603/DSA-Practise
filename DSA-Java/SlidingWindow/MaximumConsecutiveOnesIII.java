package SlidingWindow;

public class MaximumConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(longestOnes(nums,k));
    }
    public static int longestOnes(int[] nums, int k) {
        int left=0,len=0,zeroes=0,maxlen=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0) zeroes++;
            while(zeroes>k){//new window start krna hoga
                if(nums[left]==0) zeroes--;
                left++;
            }
            len=right-left+1;
            maxlen=Math.max(len,maxlen);
        }
        return maxlen;
    }
}
