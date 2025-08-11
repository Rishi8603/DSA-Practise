package SlidingWindow;

import java.util.*;

public class CountNumberOfGoodSubarray {
    public static void main(String[] args) {
        int[] nums={2,1,3,1,2,2,3,3,2,2,1,1,1,3,1};
        System.out.println(countGood(nums,11));
    }
    public static long countGood(int[] nums, int k) {
        int n=nums.length;
        long subarray =0;
        HashMap<Integer,Integer> table=new HashMap<>();

        int i=0;int j=0;int pairCnt =0;
        //Pair tells how many pair is there from i to j
        //sliding window
        while (j < n) {
            table.put(nums[j], table.getOrDefault(nums[j], 0) + 1);
            int freq = table.get(nums[j]);
            if (freq >= 2) {
                pairCnt += freq - 1;
            }

            while (pairCnt >= k) {
                subarray += n - j; // All subarrays starting from i and ending at or after j are valid
                int freqLeft = table.get(nums[i]);
                if (freqLeft >= 2) {
                    int pairFormNow = (freqLeft * (freqLeft - 1)) / 2;
                    int pairFormAfter = ((freqLeft - 1) * (freqLeft - 2)) / 2;
                    pairCnt = pairCnt - pairFormNow + pairFormAfter;
                }
                table.put(nums[i], freqLeft - 1);
                i++;
            }

            j++;
        }
        return subarray;
    }
}
