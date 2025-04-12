package Greedy;

import java.util.*;

public class FractionalKnapsack {
    static class pair implements Comparable<pair>{
        int wt,val;
        pair(int wt,int val){
            this.wt=wt;
            this.val=val;
        }
        public int compareTo(pair other) {
            double x = (double)this.val / this.wt;
            double y = (double)other.val / other.wt;
            if (x != y) {
                return Double.compare(y, x); // Correct way to compare doubles
            } else {
                return Integer.compare(other.val, this.val); // Ensures stable sorting
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> val = new ArrayList<>(Arrays.asList(1,5,7,2,7,10));
        ArrayList<Integer> wt = new ArrayList<>(Arrays.asList(4,9,6,3,7,3));
        System.out.println(fractionalKnapsack(val,wt,24));
    }
    public static double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        double value=0;
//        ArrayList<pair> list=new ArrayList<pair>();
        PriorityQueue<pair> pq=new PriorityQueue<>();
        for (int i = 0; i < wt.size(); i++) {
            pq.add(new pair(wt.get(i),val.get(i)));
        }
//        while(pq.size()>0){
//            pair top=pq.remove();
//            int x=top.val,y=top.wt;
//            System.out.println(x+","+y);
//        }
        while(capacity>0 && pq.size()>0) {
            pair top = pq.remove();
            if (capacity >= top.wt) {
                capacity = capacity - top.wt;
                value = value + top.val;
            }else{
                double b = ((double) top.val / top.wt) * capacity;
                value=value+b;
                capacity=0;
            }
        }
        return value;
    }
}
