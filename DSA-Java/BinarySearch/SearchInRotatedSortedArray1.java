package BinarySearch;

public class SearchInRotatedSortedArray1 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,0,1,2};
        int target = 1;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the mid-point is the target
            if (nums[mid] == target) {
                return mid;
            }

            // Determine which side is sorted
            if (nums[left] <= nums[mid]) {
                // Left side is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    // Target is in the left side
                    right = mid - 1;
                } else {
                    // Target is in the right side
                    left = mid + 1;
                }
            } else {
                // Right side is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    // Target is in the right side
                    left = mid + 1;
                } else {
                    // Target is in the left side
                    right = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }
}
