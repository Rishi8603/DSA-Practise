package Arrays;

public class Consecutives1 {
    public static void main(String[] args) {
        int[] nums={0};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
    public static int findMaxConsecutiveOnes(int[] nums){
        int i=0;
        int count=0;
        int max=Integer.MIN_VALUE;
        while(i<nums.length){
            if(nums[i]==1){
                count++;
                if(i==nums.length-1||(nums[i+1])==0){
                   max= Math.max(max,count);
                   count=0;
                }
            }
            i++;
        }
        if(max==Integer.MIN_VALUE) return 0;
        return max;
    }
}
