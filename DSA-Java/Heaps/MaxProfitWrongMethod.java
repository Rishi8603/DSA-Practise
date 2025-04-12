package Heaps;

import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxProfitWrongMethod {
    public static void main(String[] args) {
        int[] price={3, 2, 6, 5, 0, 1, 3};
        System.out.println(maxProfit(price));
    }
    public static PriorityQueue<Map.Entry<Integer, Integer>> maxH = new PriorityQueue<>(
            (a, b) -> b.getKey().equals(a.getKey()) ? b.getValue() - a.getValue() : b.getKey() - a.getKey()
    );
    public static PriorityQueue<Integer> minH=new PriorityQueue<>();
    public static int maxProfit(int[] prices) {
        int max = 0;
        return helper(prices, max,1,prices.length-1);
    }
    public static int helper(int[] prices,int max,int k,int idx){
        if(k>prices.length) return max;
        helper2(prices,k);
        if(maxH.peek().getValue()==prices.length-1) {
            k++;
            helper2(prices,k);
        }
        int x=maxH.peek().getValue();

        if((x<idx-1 || idx==prices.length-1) && maxH.size()!=0) {
            int temp = maxH.peek().getValue();
            minH.clear();
            for (int i = temp + 1; i < prices.length; i++) {
                minH.add(prices[i]);
                if (minH.size() > 1) minH.poll();
            }

            int diff = minH.peek() - maxH.peek().getKey();
            if (diff > max) {
                max = diff;
            }
            return helper(prices, max,k+1,x);
        }
        return max;
    }
    public static void helper2(int[] prices,int k){
        maxH.clear();
        for(int i=0;i<prices.length;i++){
            maxH.add(new AbstractMap.SimpleEntry<>(prices[i],i));
            if(maxH.size()>k) maxH.poll();
        }
    }
}



//        if(maxH.size()!=0) {
//            int temp = maxH.peek().getValue();
//            if ((temp + 1) != prices.length) {
//                for (int i = temp + 1; i < prices.length; i++) {
//                    minH.add(prices[i]);
//                    if (minH.size() > 1) minH.poll();
//                }
//
//                ans = minH.peek() - maxH.peek().getKey();
//                return ans;
//            }
//        }