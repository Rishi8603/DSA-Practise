package Graphs.BfsDfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathExitsInGraphs {
    public static void main(String[] args) {
        int[][] edges={{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}};
        System.out.println(validPath(10,edges,5,9));
    }
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        System.out.println(adj);
        visited[source] = true;
        return bfs(source, visited, adj, destination);
    }

    public static boolean bfs(int source, boolean[] visited, List<List<Integer>> adj, int destination) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while (q.size() > 0) {
            int front = q.remove();
            for (int j = 0; j < adj.get(front).size(); j++) {
                if (!visited[adj.get(front).get(j)]) {
                    if (adj.get(front).get(j) == destination) {
                        return true;
                    }
                    q.add(adj.get(front).get(j));
                    visited[adj.get(front).get(j)] = true;
                }
            }
        }
        return visited[destination];
    }
}
