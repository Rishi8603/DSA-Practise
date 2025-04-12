package Arrays;

import java.util.ArrayList;
import java.util.*;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums={-1};
        int k=2;
        rotate(nums,k);
    }
    public static void rotate(int[] nums, int k){
        k = k % nums.length; // Handle cases where k > nums.length

        for (int i = 0; i < nums.length/2; i++) {
            int temp=nums[i];
            nums[i]=nums[nums.length-i-1];
            nums[nums.length-i-1]=temp;
        }
        for (int i = 0; i < k/2; i++) {
            int temp=nums[i];
            nums[i]=nums[k-1-i];
            nums[k-1-i]=temp;
        }
        for (int i = k; i < k + (nums.length - k) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - (i - k) - 1];
            nums[nums.length - (i - k) - 1] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }
}
