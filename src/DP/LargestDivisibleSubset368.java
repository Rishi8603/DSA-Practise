package DP;
import java.util.*;

public class LargestDivisibleSubset368 {
    static List<Integer> finalList = new ArrayList<>();
    static Map<String, List<Integer>> memo = new HashMap<>();

    public static void main(String[] args) {
        int[] nums = {1,2,4,8};
        List<Integer> result = largestDivisibleSubset(nums);
        System.out.println(result);
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);  // Sort to make divisibility checks easier
        return helper(nums, -1, 0);  // -1 means no previous selected number
    }

    public static List<Integer> helper(int[] nums, int prevIndex, int currIndex) {
        if (currIndex == nums.length) {
            return new ArrayList<>();
        }

        // Memoization key
        String key = prevIndex + "," + currIndex;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Option 1: take current number if divisible
        List<Integer> take = new ArrayList<>();
        if (prevIndex == -1 || nums[currIndex] % nums[prevIndex] == 0) {
            take = helper(nums, currIndex, currIndex + 1);
            take = new ArrayList<>(take); // clone to prevent overwrite
            take.add(0, nums[currIndex]); // add current number at front
        }

        // Option 2: skip current number
        List<Integer> notTake = helper(nums, prevIndex, currIndex + 1);

        // Choose the longer Main
        List<Integer> result = (take.size() > notTake.size()) ? take : notTake;
        memo.put(key, result);
        return result;
    }
}

