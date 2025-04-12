package Arrays;

import java.util.Arrays;

public class shuffle {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 3, 2, 1};
        int n = 4;
        shuffle(nums, n);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] shuffle(int[] nums, int n) {
        // Create a new array to store the shuffled result
        int[] shuffled = new int [2 * n];

        // Fill the shuffled array by interleaving the two halves
        for (int i = 0; i < n; i++) {
            shuffled[2 * i] = nums[i];
            shuffled[2 * i + 1] = nums[n + i];
        }

        // Copy the shuffled array back to the original array
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = shuffled[i];
        }
        return nums;
    }
}
