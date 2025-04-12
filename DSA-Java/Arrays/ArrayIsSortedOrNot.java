package Arrays;

public class ArrayIsSortedOrNot {
    public static void main(String[] args) {
        int[] nums={2,1,3,4};
        System.out.println(check(nums));
    }
    public static boolean check(int[] nums) {
        int drop=0;
        int i=0;
        while(i < nums.length-1) {
            if(nums[i]>nums[i+1]){
                drop++;
            }
            i++;
        }
        if(nums[nums.length]>nums[0]){
            drop++;
        }
        if(drop<=1) return true;
        return false;
    }
}
