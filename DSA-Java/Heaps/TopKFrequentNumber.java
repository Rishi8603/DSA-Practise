package Heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentNumber {
    public static void main(String[] args) {
        int[] arr={1,1,1,2,2,3}; //1,2
        System.out.println(Arrays.toString(topKFrequent(arr,2)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans=new int[k];
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<PairMin> minH = new PriorityQueue<>();
        //update map
        for (int i = 0; i < nums.length; i++) {
            int num=nums[i];
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            minH.add(new PairMin(entry.getValue(), entry.getKey()));
            if(minH.size()>k){
                minH.remove();
            }
        }
        int  j=0;
        while(minH.size()!=0){
            ans[j]=minH.remove().second;
            j++;
        }
        return ans;
    }
}
