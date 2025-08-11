package Greedy;

import java.util.*;

public class RearrangingFruits {
    public static void main(String[] args) {
        int[] b1={4,4,4,4,3};
        int[] b2={5,5,5,5,3};
        System.out.println(minCost(b1,b2));
    }
    public static long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<basket1.length;i++){
            int num1=basket1[i];
            map.put(num1,map.getOrDefault(num1,0)+1);
        }
        for(int i=0;i<basket2.length;i++){
            int num2=basket2[i];
            map.put(num2,map.getOrDefault(num2,0)-1);
        }

        ArrayList<Integer> list=new ArrayList<>();

        //filtering the map
        long OverallMin=Long.MAX_VALUE;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()%2!=0) return -1;
            else if(entry.getValue()!=0){
                int freq= entry.getValue();
                for(int k=0;k<Math.abs(freq/2);k++){
                    list.add(entry.getKey());
                }
            }
            OverallMin=Math.min(OverallMin, entry.getKey());
        }

        Collections.sort(list);
        System.out.println(list);

        long cost=0;
        int j=basket2.length-1;
        for(int i=0;i< list.size()/2;i++){
            cost=cost+Math.min(list.get(i),2*OverallMin);
        }
        return cost;
    }
}
