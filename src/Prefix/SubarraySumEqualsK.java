package Prefix;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums={1,1,1};
        System.out.println(subarraySum(nums,2));
    }
    public static int subarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<n;i++){
            nums[i]=nums[i-1]+nums[i];
        }
        int remain=0;

        int count=0;
        for(int j = 0; j <n; j++){
            if(k==nums[j]) count++;
            remain=nums[j]-k;
            if(map.containsKey(remain)){
                count=count+map.get(remain);
            }
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
        }
        return count;
    }
}
