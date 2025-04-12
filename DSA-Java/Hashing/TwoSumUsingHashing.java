package Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumUsingHashing {
    public static void main(String[] args) {
        int[] arr ={2,5,6,11};
        int target=16;
        System.out.println(Arrays.toString(twoSum(arr,target)));
    }
    public static int[] twoSum(int[] nums,int target) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int complement=target- value;
            //check if the  complement exists in the map
            if (freqMap.containsKey(complement)) {
                //return the indices if complement is found
                return new int[] {freqMap.get(complement),i};
            }
            //add the current number with its index to the map
            freqMap.put(value,i);
        }
        //return an empty array if no solution is found
        return new int[] {};
    }
}
