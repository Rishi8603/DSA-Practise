package Graphs.BfsDfs;

import java.util.ArrayList;
import java.util.List;

public class Dfs {
    public static void main(String[] args) {
        int[][] edges={{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}};
        System.out.println(validPath(10,edges,5,9));
    }
    //path exists or not
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
        return dfs3(source, visited, adj, destination);
    }

    public static boolean dfs3(int source, boolean[] visited, List<List<Integer>> adj, int destination) {
        if (source == destination) return true; // If we reach the destination, return true

        visited[source] = true;

        for (int ele : adj.get(source)) {
            if (!visited[ele]) {
                if (dfs3(ele, visited, adj, destination)) { // Return if the path is found
                    return true;
                }
            }
        }

        return false; // If no path is found, return false
    }

    //keys and rooms
    public static boolean canVisitAllRooms(List<List<Integer>> rooms){
        boolean[] visited=new boolean[rooms.size()];
        visited[0]=true;
        dfs2(0,visited,rooms);
        for (int i = 0;i<visited.length ; i++) {
            if(visited[i]==false) return false;
        }
        return true;
    }

    public static void dfs2(int i, boolean[] visited, List<List<Integer>> rooms) {
        int n=rooms.size();
        visited[i]=true;
        for (int j = 0; j < rooms.get(i).size(); j++) {
            int key=rooms.get(i).get(j);
            if(visited[key]==false) {
                visited[key] = true;
                dfs2(key, visited, rooms);
            }
        }
    }

    //number of islands
    public static int numIslands(char[][] grid){
        int rows= grid.length;
        int cols=grid[0].length;
        int count=0;
        boolean[][] visited=new boolean[rows][cols];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (visited[i][j] == false && grid[i][j]=='1') {
                    dfs1(visited, grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs1(boolean[][] visited, char[][] grid, int i, int j) {
        int n=grid[0].length;
        int m=grid.length   ;
        visited[i][j]=true;
        //order dhyan mein rkhna hei bs left->up->right->down
        //left
        if(j>0 && grid[i][j-1]=='1' && visited[i][j-1]==false){
            dfs1(visited,grid,i,j-1);
        }
        //up
        if(i>0 && grid[i-1][j]=='1' && visited[i-1][j]==false){
            dfs1(visited,grid,i-1,j);
        }
        //right
        if(j+1<n && grid[i][j+1]=='1' && visited[i][j+1]==false){
            dfs1(visited,grid,i,j+1);
        }
        //down
        if(i+1<m && grid[i+1][j]=='1' && visited[i+1][j]==false){
            dfs1(visited,grid,i+1,j);
        }
    }


    //number of provinces question
    public static int findCircleNum(int[][] isConnected) {
        int count=0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if(visited[i]==false){
                dfs(i,visited,isConnected);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int i, boolean[] visited, int[][] isConnected) {
        int n=isConnected.length    ;
        visited[i]=true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && visited[j] == false) {
                dfs(j,visited,isConnected);
            }
        }
    }
}
