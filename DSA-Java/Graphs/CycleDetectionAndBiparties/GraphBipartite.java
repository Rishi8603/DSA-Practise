package Graphs.CycleDetectionAndBiparties;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBipartite {
    public static void main(String[] args) {
        int[][] adj = {
                {1,2,3},{0,3,4},{0,3},{0,1,2},{1}
        };
        System.out.println(isBipartite(adj));
    }
    //return true if graph  is bipartite
    //return false if it is not
    public static  boolean isBipartite(int[][] graph) {
        int n=graph.length;
        pair[] visited=new pair[n];
        for (int i = 0; i < n; i++) {
            visited[i] = new pair(false,-1); // Creating a new Pair object
        }
        for(int i=0;i<n;i++){
            if(visited[i].check==false) {
                if (!bfs(i, visited, graph)) return false;
            }
        }
        return true;
    }
    public static boolean bfs(int node,pair[] visited,int[][] graph){
        visited[node]=new pair(true,1);
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        while (q.size()>0){
            int front=q.remove();
            for (int ele:graph[front]) {
                if(visited[ele].check==false){
                    if(visited[front].color==1) visited[ele].color=2;
                    else visited[ele].color=1;
                    visited[ele].check=true;
                    q.add(ele);
                }else{
                    if(visited[ele].color==visited[front].color) return false;
                }
            }
        }
        return true;
    }
    static class pair{
        boolean check;
        int color;
        pair(boolean check,int color){
            this.check=check;
            this.color=color;
        }
    }
}
