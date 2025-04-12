package Graphs.Dijkstra;

import java.util.ArrayList;
import java.util.*;

public class PathWithMinimumEffort {
    static class Pair{
        int node;
        int effort;
        Pair(int node, int effort){
            this.node=node;
            this.effort = effort;
        }

        @Override
        public String toString() {
            return "("+node+", "+ effort +")";
        }
    }
    public static void main(String[] args) {
        int[][] height={
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}};
        System.out.println(minimumEffortPath(height));
    }
    public static int minimumEffortPath(int[][] heights) {
        //make a adj list
        int n=heights.length;
        int m=heights[0].length;
        int node =n*m;
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for (int i = 0; i < node; i++) {
            adj.add(new ArrayList<>());
        }
        int idx=0;
        for (int row = 0; row < heights.length; row++) {
            for (int col = 0; col < heights[row].length; col++) {
                //left,up,right,down
                //left
                if(col>0){
                    int effortDiff = Math.abs(heights[row][col]-heights[row][col-1]);
                    adj.get(idx).add(new Pair(idx-1, effortDiff));
                }
                //up
                if(row>0){
                    int effortDiff= Math.abs(heights[row][col]-heights[row-1][col]);
                    adj.get(idx).add(new Pair(idx-m,effortDiff));
                }
                //right
                if(col<heights[row].length-1){
                    int effortDiff= Math.abs(heights[row][col]-heights[row][col+1]);
                    adj.get(idx).add(new Pair(idx+1,effortDiff));
                }
                //down
                if(row<heights.length-1){
                    int effortDiff= Math.abs(heights[row][col]-heights[row+1][col]);
                    adj.get(idx).add(new Pair(idx+m,effortDiff));
                }
                idx++;
            }
        }
        System.out.println(adj);
        int[] effortArr =new int[node];
        Arrays.fill(effortArr,Integer.MAX_VALUE);
        effortArr[0]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.effort,b.effort));
        pq.add(new Pair(0,0));
        while(pq.size()>0){
            Pair top=pq.remove();
            for(Pair current :adj.get(top.node)){
                int minEffort =Math.max(top.effort,current.effort);
                if(minEffort < effortArr[current.node]){
                    effortArr[current.node]= minEffort;
                    System.out.print("("+current.node+","+ minEffort +")");
                    pq.add(new Pair(current.node, minEffort));
                }
            }
        }
        System.out.println();
        System.out.println(Arrays.toString(effortArr));
        return effortArr[node-1];
    }
}
