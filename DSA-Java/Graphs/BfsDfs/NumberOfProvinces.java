package Graphs.BfsDfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] arr={{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(arr));
    }
    public static int findCircleNum(int[][] isConnected) {
        int count=0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if(visited[i]==false){
                bfs(i,visited,isConnected);
                count++;
            }
        }
        return count;
    }


    public static void bfs(int i,boolean[] visited,int[][] arrr){
        Queue<Integer> q=new LinkedList<>();
        int n= arrr.length;
        visited[i]=true;
        q.add(i);
        while(q.size()>0){
            int front=q.remove()    ;
            for (int j = 0; j < n; j++) {
                if(visited[j]!=true && arrr[front][j]==1) {
                    q.add(j);
                    visited[j]=true;
                }
            }
        }
    }
}
