package Greedy;

import java.util.ArrayList;

public class JumpGame1and2 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 1, 2, 2, 1};
        System.out.println(helper(nums));
    }

    public static int helper(int[] nums) {

        int n = nums.length;
        if (n == 1) return 0; // Already at the last index

        int jumps = 0, maxReach = 0, lastJumpEnd = 0;

        for (int i = 0; i < n - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]); // Farthest we can go

            if (i == lastJumpEnd) { // When we reach the end of the current jump range
                jumps++; // Take a jump
                lastJumpEnd = maxReach; // Update the new jump boundary

                if (lastJumpEnd >= n - 1) break; // If we can reach the end, stop early
            }
        }
        return jumps;
    }
}

//    if(idx==nums.length-1){
//        minJump=jump;
//        return minJump;
//    }
//
//       for (int i = 0; i < nums[idx]; i++) {
//        if(i+idx+1<nums.length) {
//            int temp = helper(nums, i + idx + 1, jump + 1, minJump);
//            minJump=Math.min(minJump,temp);
//        }
//    }
//        return minJump;


//    public boolean canJump(int[] nums) {
//        int maxIdx=0;
//        for(int i=0;i<nums.length;i++){
//            if(maxIdx<i) return false;
//            maxIdx=Math.max(maxIdx,i+nums[i]);
//        }
//
//        return true;
//    }
