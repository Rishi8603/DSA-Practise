package Graphs.Dijkstra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPath {
    static class triplet implements Comparable<triplet>{
        int row,col,dist;
        triplet(int row, int col, int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
        public int compareTo(triplet other){
            return this.dist-other.dist;
        }
    }
    public static void main(String[] args) {
        int[][] grid={
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]!=0 ||grid[n-1][n-1]!=0) return -1;
        int[][] ans=new int[n][n];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(ans[i],Integer.MAX_VALUE);
        }
        ans[0][0]=0;
        Queue<triplet> pq=new LinkedList<>();
        pq.add(new triplet(0,0,0));
        // Prioritized movement order: Southeast → Right → Down → Others
        int[] dx = {1, 0, 1, -1, 1, -1, 0, -1}; // Row changes
        int[] dy = {1, 1, 0, 1, -1, 0, -1, -1}; // Column changes

        while (pq.size()>0){
            triplet top=pq.remove();
            int x=top.row;
            int y=top.col;
            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
    
                if (isValid(newX, newY, grid.length, grid[0].length) && grid[newX][newY]==0 ) {
//                    System.out.print("Moved to: " + newX+","+newY);
                    int totalDist = top.dist + 1;
                    if (totalDist < ans[newX][newY]) {
                        ans[newX][newY] = totalDist;
                        pq.add(new triplet(newX, newY, totalDist));
                    }
                }
            }
        }
//        System.out.println();
        System.out.println(Arrays.deepToString(ans));
        if(ans[n-1][n-1]!=Integer.MAX_VALUE) return ans[n-1][n-1]+1;
        else return -1;
    }
    public static boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
