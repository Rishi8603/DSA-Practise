package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class alldupinarr {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> ans = findDuplicates(nums); // Correct method call
        System.out.println(ans);
    }

    public static List<Integer> findDuplicates(int[] nums) { // Method should be static
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(i, correct, nums); // Correct order of parameters
            } else {
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                ans.add(nums[index]);
            }
        }
        //sort the answer
        Collections.sort(ans);
        return ans;
    }

    static void swap(int first, int second, int[] arr) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}