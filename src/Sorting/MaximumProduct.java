package Sorting;


import java.util.Arrays;

public class MaximumProduct {
    public static void main(String[] args) {
        int[] nums={-1,-2,-3,-4};
        System.out.println(maximumProduct(nums));
    }
    public static int maximumProduct(int[] nums){
        Arrays.sort(nums);
        int prod=0;
        if(nums[0]>=0){
            prod=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        }else {
            if(nums[nums.length-1]<0) {
                prod=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
            }else{
                prod=nums[0]*nums[1]*nums[nums.length-1];
            }
        }
        return prod;
    }
}
