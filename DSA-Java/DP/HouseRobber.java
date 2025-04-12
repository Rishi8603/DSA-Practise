package DP;
import java.util.*;
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums={2,7,9,3,1};
        System.out.println(rob1(nums));
        System.out.println(Arrays.toString(t));
        System.out.println(rob2(nums));
        System.out.println(Arrays.toString(t));
    }
    //method 1..starting from i=0
    //method 2..starting from back i=n
    static int[] t;
    public static int rob1(int[] nums) {
        int n=nums.length;
        t=new int[nums.length+1];
        Arrays.fill(t,-1);
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        helper1(nums);
        int max=0;
        for(int num:t){
            max=Math.max(num,max);
        }
        return max;
    }
    public static int helper1(int[] nums){
        //initiallisation
        t[0]=nums[0];
        t[1]=Math.max(nums[0],nums[1]);

        //main code
        for(int k=2;k<nums.length;k++){
            t[k]=Math.max(t[k-1],nums[k]+t[k-2]);
        }
        return t[nums.length];
    }
    public static int rob2(int[] nums) {
        int n=nums.length;
        t=new int[nums.length];
        Arrays.fill(t,-1);
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        helper2(nums);
        int max=0;
        for(int num:t){
            max=Math.max(num,max);
        }
        return max;
    }
    public static int helper2(int[] nums){
        int n=nums.length;
        //initiallisation
        t[n-1]=nums[n-1];
        t[n-2]=Math.max(nums[n-1],nums[n-2]);

        //main code
        for(int k=n-3;k>=0;k--){
            t[k]=Math.max(t[k+1],nums[k]+t[k+2]);
        }
        return t[nums.length-1];
    }
}
