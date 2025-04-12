package SlidingWindow;

public class LongestArrayOf1sAfterDeletion {
    public static void main(String[] args) {
        int[] nums={0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(nums));
    }
    public static int longestSubarray(int[] nums) {
        //very simple code //detailed explaination in leetcode
        int left=0,zeroes=0,len=0,maxlen=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0) zeroes++;
            while(zeroes>1){
                if(nums[left]==0) zeroes--;
                left++;
            }
            len=right-left;
            maxlen=Math.max(len,maxlen);
        }
        return maxlen;
    }
}
