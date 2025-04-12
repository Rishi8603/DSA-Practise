package Heaps;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplication {
    public static void main(String[] args) {
        int[] arr={2,1,3,5,6};
        System.out.println(Arrays.toString(getFinalState(arr,5,2)));
    }
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        int[] ans=new int[nums.length];
        PriorityQueue<Map.Entry<Integer, Integer>> minH = new PriorityQueue<>(
                (a, b) -> a.getKey().equals(b.getKey()) ? a.getValue() - b.getValue() : a.getKey() - b.getKey()
        );
        for (int j = 0; j < nums.length; j++) {
            minH.add(new AbstractMap.SimpleEntry<>(nums[j],j));
        }
        for (int i = 0; i <k ; i++) {
            int x=minH.peek().getKey();
            int temp=minH.peek().getValue();
            minH.remove();
            x=x*multiplier;
            minH.add(new AbstractMap.SimpleEntry<>(x,temp));
        }
        while(minH.size()!=0){
            ans[minH.peek().getValue()]=minH.peek().getKey();
            minH.remove();
        }
        return ans;
    }
}
