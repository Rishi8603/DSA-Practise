package SlidingWindow;

import java.util.Arrays;

public class CountNumberOfNiceSubarray {
    public static void main(String[] args) {
        int[] nums={2,2,2,1,2,2,1,2,2,2};
        System.out.println(numberOfSubarrays(nums,2));
    }
    public static int numberOfSubarrays(int[] nums, int k){
        int n=nums.length;
        int a=0,b=0,i=0,j=0,count=0;
        //initial window setup
        while(i<n && nums[i]%2==0) i++;
        j=i+1;k--;
        while(j<n && k>0){
            if(nums[j]%2==1)k--;
            j++;
        }j--;
        if(k>0) return 0;
        b=j+1;
        while(b<n && nums[b]%2==0) b++;
        b--;
        while(b<n){//sliding window
            count=count+(i-a+1)*(b-j+1);
            a=i+1;i++;
            while(i<n && nums[i]%2==0) i++;

            j=b+1;
            b=j+1;
            while(b<n && nums[b]%2==0) b++;
            b--;
        }
        return count;
    }
}
