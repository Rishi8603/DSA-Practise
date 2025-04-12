package Arrays;

import java.util.Arrays;

public class permutationarray {
    public static void permute(int[] nums, int start) {
        if (start == nums.length) {
            System.out.println(Arrays.toString(nums));
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                permute(nums, start + 1);
                swap(nums, start, i);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 4, 1, 3};
        permute(arr, 0);
    }
}
