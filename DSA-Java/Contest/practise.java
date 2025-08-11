package Contest;

public class practise {
    public static void main(String[] args) {
        int[] arr={2, 4, 6, 5, 7};
        System.out.println(minSwaps(arr));
    }
    public static int minSwaps(int[] nums) {
        int evenCount = 0;
        int oddCount = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        if (Math.abs(evenCount - oddCount) > 1) {
            return -1;
        }

        int swapsStartEven = Integer.MAX_VALUE;
        int swapsStartOdd = Integer.MAX_VALUE;
        int n = nums.length;

        // Pattern 1: Even at 0,2,4...
        if (evenCount >= (n + 1) / 2) {
            swapsStartEven = countSwaps(nums, 0);
        }

        // Pattern 2: Odd at 0,2,4...
        if (oddCount >= (n + 1) / 2) {
            swapsStartOdd = countSwaps(nums, 1);
        }

        int result;
        if (swapsStartEven < swapsStartOdd) {
            result = swapsStartEven;
        } else {
            result = swapsStartOdd;
        }

        if (result == Integer.MAX_VALUE) {
            return -1;
        }

        return result;
    }
    // Helper function to count swaps for a given starting parity
    private static int countSwaps(int[] nums, int startParity) {
        int swapCount = 0;
        int targetIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == startParity) {
                swapCount += Math.abs(i - targetIndex);
                targetIndex += 2;
            }
        }
        return swapCount;
    }
}
