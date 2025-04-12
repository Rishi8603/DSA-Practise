package BinarySearch;

public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,0,2};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the middle element is smaller than the rightmost, the minimum is in the left half
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                // Otherwise, the minimum is in the right half
                left = mid + 1;
            }
        }

        // The loop ends when left == right, pointing to the minimum element
        return nums[left];
    }
}
