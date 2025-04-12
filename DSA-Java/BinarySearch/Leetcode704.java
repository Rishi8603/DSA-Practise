package BinarySearch;

public class Leetcode704 {
    public static void main(String[] args) {
        int[] nums={4,5};
        int target=0;
        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target){
        int s=0;
        int e=nums.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(target<nums[m]){
                e=m-1;
            }else if(target>nums[m]){
                s=m+1;
            }else{
                return m;
                }
        }
        return -1;
    }
}
