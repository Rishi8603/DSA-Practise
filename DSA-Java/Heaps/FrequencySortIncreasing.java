package Heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySortIncreasing {
    public static void main(String[] args) {
        int[] arr={1,1,2,2,2,3};
        System.out.println(Arrays.toString(frequencySort(arr)));
    }
    public static int[] frequencySort(int[] nums) {
        int[] ans=new int[nums.length];
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<PairMin> minHeap = new PriorityQueue<>();
        //map update
        for (int i = 0; i < nums.length; i++) {
            int num=nums[i];
            map.put(num, map.getOrDefault(num,0)+1);
        }
        //heap update
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            minHeap.add(new PairMin(entry.getValue(), entry.getKey()));
        }
        int j=0;
        int size=minHeap.size();
        for (int i = 0; i <size ; i++) {
            int count= minHeap.peek().first;
            int x= minHeap.remove().second;
            while(count!=0){
                ans[j]=x;
                count--;
                j++;
            }
        }
        return ans;
    }
}
