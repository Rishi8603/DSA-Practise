package Graphs.Prims;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinCost {
    static class triplet implements Comparable<triplet>{
        int node,parent,weight;
        triplet(int node,int parent,int weight){
            this.node=node;
            this.parent=parent;
            this.weight=weight;
        }
        public int compareTo(triplet t){
            if(this.weight==t.weight) return Integer.compare(this.node,t.node);
            return Integer.compare(this.weight,t.weight);
        }
    }
    public static void main(String[] args) {
        int[][] point={{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(minCostConnectPoints(point));
    }
    public static int minCostConnectPoints(int[][] points) {
        int n=points.length;
        boolean[] vis=new boolean[n];
        int sum=0;
        PriorityQueue<triplet> pq=new PriorityQueue<>();
        pq.add(new triplet(0,-1,0));
        while(pq.size()>0){
            triplet top=pq.remove();
            if(vis[top.node]==true) continue;
            sum+=top.weight;
            vis[top.node]=true;
            for (int i = 0; i < points.length; i++) {
                if(i==top.node || i==top.parent) continue;
                if(vis[i]==true) continue;
                int x1=points[top.node][0];
                int y1=points[top.node][1];
                int x2=points[i][0];
                int y2=points[i][1];
                int mDis=Math.abs(x2-x1)+Math.abs(y2-y1);
                pq.add(new triplet(i, top.node,mDis));
            }
        }
        return sum;
    }
}
