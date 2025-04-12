package Hashing;

import java.util.HashMap;

public class Leetcode136 {
    public static void main(String[] args) {
        int[] nums={-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,354};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums){
        HashMap<Integer,Integer> list=new HashMap<>();
        //algo of hashmap
        for (int i = 0; i < nums.length; i++) {
            int num=nums[i];
            list.put(num,list.getOrDefault(num,0)+1);
        }

        int i=0;
        while(i<nums.length){
            int val=list.get(nums[i]);
            if(val==1){
                return nums[i];
            }
            i++;
        }
        return -1;
    }
}
