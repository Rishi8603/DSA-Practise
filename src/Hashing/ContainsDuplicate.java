package Hashing;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums={1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums){
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        if(freq.size()==nums.length) return false;
        else return true;
    }
}
