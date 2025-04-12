package Practise;

import java.util.*;
import java.math.BigInteger; // Keep just in case, though String ops suffice

public class Main {  // Class name must be 'Main'
    public static void main(String[] args) {
        int[] nums={3,3};
        System.out.println(minOperations(nums,3));
    }
    public static int minOperations(int[] nums, int k) {
        int operation=0;
        int n=nums.length;
        Arrays.sort(nums);
        int i=n-1;
        while(i>0){
            int temp=nums[i];
            while(i>0 && temp==nums[i]){
                i--;
            }
            if(temp!=nums[i] && nums[i]>=k) operation++;
        }

        if(nums[0]<k) return -1;
        else if(nums[0]==k) return operation;
        else return ++operation;
    }
}