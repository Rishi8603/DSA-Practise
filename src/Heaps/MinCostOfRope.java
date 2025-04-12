package Heaps;

import java.util.PriorityQueue;

public class MinCostOfRope {
    public static void main(String[] args) {
        System.out.println(minCost(new int[]{1,2,3,4,5}));
    }
    public static int minCost(int[] arr) {
        int cost=0;
        PriorityQueue<Integer> minH=new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            minH.add(arr[i]);
        }
        while(minH.size()!=1){
            int x=minH.remove();
            int y=minH.remove() ;
            int temp=x+y;
            cost=cost+temp;
            minH.add(temp);
        }
        return cost;
    }
}
