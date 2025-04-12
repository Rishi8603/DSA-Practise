package SlidingWindow;

import java.util.HashMap;

public class BinarySubarraySum {
    public static void main(String[] args) {
        int[] nums={0,0,0,0,0};
        System.out.println(numSubarraysWithSum(nums,0));
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length;
        // Special-case: if goal is 0, count all subarrays that contain only zeros.
        if (goal == 0) {
            int res = 0, countZeros = 0;
            for (int x : nums) {
                if (x == 0)
                    countZeros++;
                else {
                    res += countZeros * (countZeros + 1) / 2;
                    countZeros = 0;
                }
            }
            res += countZeros * (countZeros + 1) / 2;
            return res;
        }
        int a=0,b=0,i=0,j=0;
        int sum=0;int count=0;

        // --- INITIAL WINDOW SETUP ---
        // Skip any leading zeros until we get the first 1.
        while (i < n && nums[i] == 0) {
            i++;
        }
        // If no 1 is found, no valid subarray exists.
        if (i >= n) return 0;
        j=i+1; sum=1;
        while(j<n && sum!=goal){
            sum=sum+nums[j];
            j++;
        }j--;
        if(sum<goal) return 0;
        // At this point window [i, j] (with j inclusive) has exactly goal ones.
        b=j+1;
        while(b<n && nums[b]==0) b++;
        b--;
        while(b<n){//sliding window
            count=count+(i-a+1)*(b-j+1);
            a=i+1;i++;  if (i >= n) break;
            while(i<n && nums[i]==0) i++;
            if (i >= n) break;
            // First, subtract the 1 that left:
            sum--;

            // Move j forward to add the next 1.
            j++;
            while (j < n && nums[j] == 0) {
                j++;
            }
            if (j >= n) break;  // no more ones to extend the window
            // Add the new Main to restore sum to goal.
            sum++;
            b=j+1;
            while(b<n && nums[b]==0) b++;
            b--;
        }

        return count;
    }
}
