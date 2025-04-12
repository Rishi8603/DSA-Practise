package Sorting;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr={1};
        System.out.println(majorityElement(arr));
    }
    public static int majorityElement(int[] nums){
//        Arrays.sort(nums);
        HashMap<Integer,Integer> freq= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num=nums[i];
            freq.put(num, freq.getOrDefault(num,0)+1);
        }
        int i=0;
        int var=0;
        int max=Integer.MIN_VALUE;
        while(i<nums.length){
            if(i==0 ||nums[i]!=nums[i-1]){
                i++;
            }
            else if(freq.get(nums[i])>max){
                max=freq.get(nums[i]);
                var=nums[i];
                i++;
            }else{
                i++;
            }
        }
        if(nums.length==1) return nums[0];
     return var;
    }
}
