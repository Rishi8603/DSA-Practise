package Graphs;

import Graphs.Dijkstra.CheapestFlight;

import java.io.FilterOutputStream;
import java.util.*;

public class practise {
    static class Pair {
        int node;
        int time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public String toString() {
            return "(" + node + ", " + time + ")";
        }
    }
    static class triplet {
        int node;
        int time;
        int stops;
        triplet(int node, int time, int stops){
            this.node =node;
            this.time =time;
            this.stops =stops;
        }
        @Override
        public String toString() {
            return "("+ node +", "+ time +","+ stops +")";
        }
    }
    public static void main(String[] args) {
        int[][] flight={{0,1,5}, {1,2,5}, {0,3,2}, {3,1,2}, {1,4,1}, {4,2,1}};
        System.out.println(findCheapestPrice(5,flight,0,2,2));
    }
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        System.out.println(adj);
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src]=0;
        PriorityQueue<triplet> q = new PriorityQueue<>((a, b) -> {
            if (a.stops==b.stops) {
                return Integer.compare(a.time, b.time); // Sort by time if nodes are different
            }else return Integer.compare(a.stops,b.stops);
        });
        q.add(new triplet(src,0,0));
        while(q.size()>0){
            triplet top=q.remove();
            int stop= top.stops;

            for (Pair current:adj.get(top.node)){
                if(current.node==dst && stop>=k+1) continue;
                int totalTime=current.time+ top.time;
                if(totalTime<ans[current.node]){
                    ans[current.node]=totalTime;
                    q.add(new triplet(current.node,totalTime,stop+1));
                }
            }
        }
        System.out.println(Arrays.toString(ans));
        if(ans[dst]==Integer.MAX_VALUE) return -1;
        else return ans[dst];
    }
}
