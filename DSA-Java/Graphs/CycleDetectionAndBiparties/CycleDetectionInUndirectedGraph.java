package Graphs.CycleDetectionAndBiparties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionInUndirectedGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>(Arrays.asList(1)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2)));
        adj.add(new ArrayList<>(Arrays.asList(1, 3,6)));
        adj.add(new ArrayList<>(Arrays.asList(2, 4,5)));
        adj.add(new ArrayList<>(Arrays.asList(3)));
        adj.add(new ArrayList<>(Arrays.asList(3,6)));
        adj.add(new ArrayList<>(Arrays.asList(2,5)));
        System.out.println(adj);
        System.out.println(isCycle(adj));
    }
    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj){
        boolean[] visited=new boolean[adj.size()];
        int count=0;
        for (int i = 0; i < adj.size(); i++) {
            if(visited[i]==false){
//                if(bfs(i,visited,adj)) return true;
                if(dfs(i,-1,visited,adj)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(int node,int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[node]=true;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int x=adj.get(node).get(i);
            if(x!=parent) {
                if(visited[x]==true){
                    return true;
                }
                visited[x] = true;
                if(dfs(x, node, visited, adj)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean bfs(int j,boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        Queue<Pairq> q=new LinkedList<>();
        visited[j]=true;
        q.add(new Pairq(j,-1));
        while(q.size()>0){
            Pairq front=q.remove()  ;
            int node=front.node;
            int parent= front.parent;
            for (int i=0;i<adj.get(node).size();i++) {
                if(adj.get(node).get(i)!=parent) {
                    if (visited[adj.get(node).get(i)] == true) {
                       return true;
                    }
                    visited[adj.get(node).get(i)]=true;
                    q.add(new Pairq(adj.get(node).get(i),node));
                }
            }
        }
        return false;
    }
    static class Pairq{
        int node;
        int parent;
        Pairq(int node, int parent){
            this.node=node;
            this.parent=parent  ;
        }
    }
}
