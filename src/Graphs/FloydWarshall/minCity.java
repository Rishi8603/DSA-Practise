package Graphs.FloydWarshall;

import java.util.*;

public class minCity {
    public static void main(String[] args) {
        int[][] city={{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        System.out.println(findTheCity(5,city,2));
    }
    public static int findTheCity(int n, int[][] edges, int Thresold) {
        //first make a adj matrix
        int[][] adj=new int[n][n];
        for (int i = 0; i < adj.length; i++) {
            Arrays.fill(adj[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj[u][v]=wt;
            adj[v][u]=wt;
        }
        //floyd warshall
        for(int k = 0; k <n; k++){//through k
            for(int i = 0; i <n; i++){
                if(i==k) continue;;
                for(int j = 0; j <n; j++){
                    if(j==k) continue;
                    if(adj[i][k]!=Integer.MAX_VALUE && adj[k][j]!=Integer.MAX_VALUE) {
                        adj[i][j] = Math.min(adj[i][j], (adj[i][k] + adj[k][j]));
                    }
                }
            }
        }
        int minCity=Integer.MAX_VALUE;
        int minCount=Integer.MAX_VALUE;
        for(int i=0;i<adj.length;i++){
            int count=0;
            for (int j = 0; j < adj[i].length; j++) {
                if(i==j) continue;
                if(adj[i][j]<=Thresold) count++;
            }
            if(count<=minCount){
                minCount=count;
                minCity=i;
            }
        }
        return minCity;
    }
}
