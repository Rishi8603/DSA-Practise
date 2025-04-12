package Heaps;

import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

public class prac {
    public static void main(String[] args) {
        int[] price={3,2,6,5,0,3};
        System.out.println(maxProfit(price,1));
    }
    public static PriorityQueue<Map.Entry<Integer, Integer>> maxH = new PriorityQueue<>((a, b) -> b.getKey().compareTo(a.getKey())) ;
    public static PriorityQueue<Integer> minH=new PriorityQueue<>();
    public static int maxProfit(int[] prices,int k){

        for(int i=0;i<prices.length;i++){
            maxH.add(new AbstractMap.SimpleEntry<>(prices[i],i));
            if(maxH.size()>k) maxH.poll();
        }
        return maxH.peek().getKey();
    }
}
